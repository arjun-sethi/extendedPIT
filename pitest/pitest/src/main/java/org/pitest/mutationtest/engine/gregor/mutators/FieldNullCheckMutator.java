package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.objectweb.asm.Label;


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
}

  class FieldNullCheck1 extends MethodVisitor {
    private final MethodMutatorFactory factory;
    private final MutationContext      context;

    Label ifnonull = new Label();
    Label exit = new Label();

    FieldNullCheck1(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
      super(Opcodes.ASM6, delegateMethodVisitor);
      this.factory = factory;
      this.context = context;
    }


    @Override
    public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
      if (opcode == Opcodes.GETFIELD) {

        final MutationIdentifier newId = this.context.registerMutation(this.factory, "Placed null check before field dereference");
        if (this.context.shouldMutate(newId)) {
          this.mv.visitInsn(Opcodes.DUP); //duplicate objectref on stack
          this.mv.visitJumpInsn(Opcodes.IFNONNULL,ifnonull); //if objectref == null, jump to label
            this.mv.visitInsn(Opcodes.POP); //duplicate objectref on stack
                        //super.visitInsn(Opcodes.ACONST_NULL);

        if (desc.equalsIgnoreCase("I")) {
            super.visitInsn(Opcodes.ICONST_0);
        } else if (desc.equalsIgnoreCase("D")) {
            super.visitInsn(Opcodes.DCONST_0);
        } else if (desc.equalsIgnoreCase("F")) {
            super.visitInsn(Opcodes.FCONST_0);
        } else if (desc.equalsIgnoreCase("L")) {
            super.visitInsn(Opcodes.LCONST_0);
        } else {
            super.visitInsn(Opcodes.ACONST_NULL);
        }
            this.mv.visitJumpInsn(Opcodes.GOTO,exit); //if objectref == null, jump to label
          this.mv.visitLabel(ifnonull);
            super.visitFieldInsn(opcode, owner, name, desc);
          this.mv.visitLabel(exit);
        } else {
        super.visitFieldInsn(opcode, owner, name, desc);
        }
      } else {
        super.visitFieldInsn(opcode, owner, name, desc);
      }
    }
  }
