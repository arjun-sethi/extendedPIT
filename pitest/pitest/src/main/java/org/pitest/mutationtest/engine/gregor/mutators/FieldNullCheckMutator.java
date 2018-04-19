package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

/*M1 mutator 1
  i.e. when a field is dereferenced, only perform the field dereference if object reference is not null
  */
public class FieldNullCheckMutator {
	public enum FieldNullCheck implements MethodMutatorFactory {

    FIELD_NULL_CHECK_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new FieldNullCheck1(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
      return this.getClass().getName();
    }

    @Override
    public String getName() {
      return name();
    }
  }

  class FieldNullCheck1 extends MethodVisitor {
  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  FieldNullCheck1(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) 
  {
    if (opcode == Opcodes.GETFIELD)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Placed null check before field dereference");
      if (this.context.shouldMutate(newId)) 
      	{
	      	this.mv.visitInsn(Opcodes.DUP)	//duplicate objectref on stack
	      	if((this.mv.visitInsn(Opcodes.POP))!=null) //pop objectref and check if it is null
	      	{
	        	this.mv.visitInsn(opcode);	//if objectref is not null then proceed with getfield operation
	      	} 
      		else 
      		{
      			this.mv.visitInsn(Opcodes.POP);	//else pop 2nd copy of objectref from stack to ignore the operation
      		}
    	} 
    else 
    {
      super.visitFieldInsn(opcode, owner, name, desc);
    }
  	}


	}
}