package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

/*scalar variable replacment
  i.e. tmp=a+b -> tmp=a+a or tmp=b+b or tmp=tmp+b or tmp=a+tmp or tmp=tmp+tmp
  */
public class SVRMutator {

  public enum SVRMutator1 implements MethodMutatorFactory {

    SVR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new SVRMethodVisitor1(this, context, methodVisitor);
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
  public enum SVRMutator2 implements MethodMutatorFactory {

    SVR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new SVRMethodVisitor2(this, context, methodVisitor);
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

 /* public enum SVRMutator3 implements MethodMutatorFactory {

    SVR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new SVRMethodVisitor3(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
      return this.getClass().getName();
    }

    @Override
    public String getName() {
      return name();
    }
  }*/
}

//C=A+B -> C=A+A
class SVRMethodVisitor1 extends MethodVisitor {
  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  SVRMethodVisitor1(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {
    if (opcode == Opcodes.IADD || opcode == Opcodes.ISUB || opcode == Opcodes.IDIV || opcode == Opcodes.IMUL || opcode == Opcodes.IREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Integer TEMP=A+B mutated to TEMP=A+A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP); //pop B from top
        this.mv.visitInsn(Opcodes.DUP); //duplicate A at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FADD || opcode == Opcodes.FSUB || opcode == Opcodes.FDIV || opcode == Opcodes.FMUL || opcode == Opcodes.FREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Float TEMP=A+B mutated to TEMP=A+A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP); //pop B from top
        this.mv.visitInsn(Opcodes.DUP); //duplicate A at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LADD || opcode == Opcodes.LSUB || opcode == Opcodes.LDIV || opcode == Opcodes.LMUL || opcode == Opcodes.LREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Long TEMP=A+B mutated to TEMP=A+A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP2);//pop 2 words of B
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of A at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    }  else if (opcode == Opcodes.DADD || opcode == Opcodes.DSUB || opcode == Opcodes.DDIV || opcode == Opcodes.DMUL || opcode == Opcodes.DREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Double TEMP=A+B mutated to TEMP=A+A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP2);  //pop 2 words of B from top
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of A at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else {
      super.visitInsn(opcode);
    }
  }

}

//C=A+B -> C=B+B
class SVRMethodVisitor2 extends MethodVisitor {
  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  SVRMethodVisitor2(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {
    if (opcode == Opcodes.IADD || opcode == Opcodes.ISUB || opcode == Opcodes.IDIV || opcode == Opcodes.IMUL || opcode == Opcodes.IREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Integer TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP_X1); //place copy of B at 3rd position from top
        this.mv.visitInsn(Opcodes.POP2); //pop top two values (B and A), so left with just B
        this.mv.visitInsn(Opcodes.DUP); //duplicate B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FADD || opcode == Opcodes.FSUB || opcode == Opcodes.FDIV || opcode == Opcodes.FMUL || opcode == Opcodes.FREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Float TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP_X1); //place copy of B at 3rd position from top
        this.mv.visitInsn(Opcodes.POP2); //pop top two values (B and A), so left with just B
        this.mv.visitInsn(Opcodes.DUP); //duplicate B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LADD || opcode == Opcodes.LSUB || opcode == Opcodes.LDIV || opcode == Opcodes.LMUL || opcode == Opcodes.LREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Long TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2); //place copy of B at 5th and 6th positions
        this.mv.visitInsn(Opcodes.POP2); //pop 1st and 2nd pos
        this.mv.visitInsn(Opcodes.POP2); //pop 3rd and 4th pos, leave 5th and 6th pos at top
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    }  else if (opcode == Opcodes.DADD || opcode == Opcodes.DSUB || opcode == Opcodes.DDIV || opcode == Opcodes.DMUL || opcode == Opcodes.DREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Double TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2); //place copy of B at 5th and 6th positions
        this.mv.visitInsn(Opcodes.POP2); //pop 1st and 2nd pos
        this.mv.visitInsn(Opcodes.POP2); //pop 3rd and 4th pos, leave 5th and 6th pos at top
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else {
      super.visitInsn(opcode);
    }
  }

}

//C=A+B -> C=A+C
/*class SVRMethodVisitor3 extends MethodVisitor {
  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  SVRMethodVisitor3(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {
    if (opcode == Opcodes.IADD || opcode == Opcodes.ISUB || opcode == Opcodes.IDIV || opcode == Opcodes.IMUL || opcode == Opcodes.IREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Integer TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP); //place copy of B at 3rd position from top
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FADD || opcode == Opcodes.FSUB || opcode == Opcodes.FDIV || opcode == Opcodes.FMUL || opcode == Opcodes.FREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Float TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP_X1); //place copy of B at 3rd position from top
        this.mv.visitInsn(Opcodes.POP2); //pop top two values (B and A), so left with just B
        this.mv.visitInsn(Opcodes.DUP); //duplicate B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LADD || opcode == Opcodes.LSUB || opcode == Opcodes.LDIV || opcode == Opcodes.LMUL || opcode == Opcodes.LREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Long TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2); //place copy of B at 5th and 6th positions
        this.mv.visitInsn(Opcodes.POP2); //pop 1st and 2nd pos
        this.mv.visitInsn(Opcodes.POP2); //pop 3rd and 4th pos, leave 5th and 6th pos at top
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    }  else if (opcode == Opcodes.DADD || opcode == Opcodes.DSUB || opcode == Opcodes.DDIV || opcode == Opcodes.DMUL || opcode == Opcodes.DREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Double TEMP=A+B mutated to TEMP=B+B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2); //place copy of B at 5th and 6th positions
        this.mv.visitInsn(Opcodes.POP2); //pop 1st and 2nd pos
        this.mv.visitInsn(Opcodes.POP2); //pop 3rd and 4th pos, leave 5th and 6th pos at top
        this.mv.visitInsn(Opcodes.DUP2); //duplicate 2 words of B at top
        this.mv.visitInsn(opcode); //add/subtracct/mul/div/mod two numbers and push onto stack
      } else {
        super.visitInsn(opcode);
      }
    } else {
      super.visitInsn(opcode);
    }
  }

}*/