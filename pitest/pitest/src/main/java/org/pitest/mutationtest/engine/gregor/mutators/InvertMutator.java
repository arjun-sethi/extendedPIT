package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class InvertMutator {

  public enum InvertMutator1 implements MethodMutatorFactory {

    INVERT_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new InvertMethodVisitor1 (this, context, methodVisitor);
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

  class InvertMethodVisitor1 extends MethodVisitor {

    private final MethodMutatorFactory factory;
    private final MutationContext context;

    InvertMethodVisitor1 (final MethodMutatorFactory factory,
                            final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(Opcodes.ASM6, delegateMethodVisitor);
        this.factory = factory;
        this.context = context;
    }

  @Override
  public void visitVarInsn(final int opcode, final int var) {
      if (opcode == Opcodes.ILOAD) {
        final MutationIdentifier newId = this.context.registerMutation(this.factory, "Inverted sign of Integer Variable ");

        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var); //load integer value from variable index var onto stack
            this.mv.visitInsn(Opcodes.ICONST_M1); //push -1 on stack
            this.mv.visitInsn(Opcodes.IMUL);  //multiple two integers and push result
            this.mv.visitVarInsn(Opcodes.ISTORE, var);  //place integer from stack into local var
            super.visitVarInsn(opcode, var);

        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.FLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(this.factory, "Inverted sign of Float Variable ");

        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
            this.mv.visitLdcInsn(new Float("-1.0"));
            this.mv.visitInsn(Opcodes.FMUL);
            this.mv.visitVarInsn(Opcodes.FSTORE, var);
            super.visitVarInsn(opcode, var);

        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.LLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(this.factory, "Inverted sign of Long Variable ");

        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
            this.mv.visitLdcInsn(new Long("-1"));
            this.mv.visitInsn(Opcodes.LMUL);
            this.mv.visitVarInsn(Opcodes.LSTORE, var);
            super.visitVarInsn(opcode, var);

        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.DLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(this.factory, "Inverted sign of Double Variable ");

        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
            this.mv.visitLdcInsn(new Double("-1.0"));
            this.mv.visitInsn(Opcodes.DMUL);
            this.mv.visitVarInsn(Opcodes.DSTORE, var);
            super.visitVarInsn(opcode, var);

        } else {
            super.visitVarInsn(opcode, var);
        }
      } else {
            super.visitVarInsn(opcode, var);
        }
    }
  }