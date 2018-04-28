package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.classinfo.ClassByteArraySource;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class UOIMutator {
    public enum AddIncrementsMutator implements MethodMutatorFactory {

        UOI_MUTATOR;
        
        @Override
        public MethodVisitor create(final MutationContext context,
            final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
          return new AddIncrementsMutator1(this, context, methodVisitor);
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
    
    public enum AddDecrementsMutator implements MethodMutatorFactory {

        UOI_MUTATOR;

        @Override
        public MethodVisitor create(final MutationContext context,
            final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
          return new AddDecrementsMutator1(this, context, methodVisitor);
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

class AddIncrementsMutator1 extends MethodVisitor {

  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  AddIncrementsMutator1(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }
  
  @Override
  public void visitVarInsn(final int opcode, final int var) {
    if (opcode == Opcodes.ILOAD) {
      final MutationIdentifier newId = this.context.registerMutation(
          this.factory, "Integer Add 1 (++x)");
      if (this.context.shouldMutate(newId)) {
          this.mv.visitVarInsn(opcode, var); //store var on stack
          this.mv.visitInsn(Opcodes.ICONST_1); //add +1 to stack
          this.mv.visitInsn(Opcodes.IADD); //add two word and push result
          this.mv.visitVarInsn(Opcodes.ISTORE, var);  //store result in var
          super.visitVarInsn(opcode, var);
      } else {
          super.visitVarInsn(opcode, var);
      }
    } else if (opcode == Opcodes.DLOAD) {
      final MutationIdentifier newId = this.context.registerMutation(
          this.factory, "Double add 1 (++x)");
      if (this.context.shouldMutate(newId)) {
          this.mv.visitVarInsn(opcode, var);  //store value in var on stack
          this.mv.visitInsn(Opcodes.DCONST_1);  //place doulble 1.0 on stack
          this.mv.visitInsn(Opcodes.DADD);  //add top two values and push result
          this.mv.visitVarInsn(Opcodes.DSTORE, var);  //store result in var
          super.visitVarInsn(opcode, var);  //
      } else {
          super.visitVarInsn(opcode, var);
      }
    } else if (opcode == Opcodes.FLOAD) {
      final MutationIdentifier newId = this.context.registerMutation(
          this.factory, "Added float increment");
      if (this.context.shouldMutate(newId)) {
          this.mv.visitVarInsn(opcode, var);
          this.mv.visitInsn(Opcodes.FCONST_1);
          this.mv.visitInsn(Opcodes.FADD);
          this.mv.visitVarInsn(Opcodes.FSTORE, var);
          super.visitVarInsn(opcode, var);
      } else {
          super.visitVarInsn(opcode, var);
      }
    } else if (opcode == Opcodes.LLOAD) {
      final MutationIdentifier newId = this.context.registerMutation(
          this.factory, "Added long increment");
      if (this.context.shouldMutate(newId)) {
          this.mv.visitVarInsn(opcode, var);
          this.mv.visitInsn(Opcodes.LCONST_1);
          this.mv.visitInsn(Opcodes.LADD);
          this.mv.visitVarInsn(Opcodes.LSTORE, var);
          super.visitVarInsn(opcode, var);
      } else {
          super.visitVarInsn(opcode, var);
      }
    } else {
      super.visitVarInsn(opcode, var);
    }
  }

}

class AddDecrementsMutator1 extends MethodVisitor {

  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  AddDecrementsMutator1(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }
  
  @Override
  public void visitVarInsn(final int opcode, final int var) {
    if (opcode == Opcodes.ILOAD) {
      final MutationIdentifier newId = this.context.registerMutation(
          this.factory, "Added integer decrement");
        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
          this.mv.visitInsn(Opcodes.ICONST_M1);
          this.mv.visitInsn(Opcodes.IADD);
            this.mv.visitVarInsn(Opcodes.ISTORE, var);
            super.visitVarInsn(opcode, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.DLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(
            this.factory, "Added double decrement");
        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
            this.mv.visitInsn(Opcodes.DCONST_1);  //place doulble 1.0 on stack
            this.mv.visitInsn(Opcodes.DSUB);
            this.mv.visitVarInsn(Opcodes.DSTORE, var);
            super.visitVarInsn(opcode, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.FLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(
            this.factory, "Added float decrement");
        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
          this.mv.visitInsn(Opcodes.FCONST_1);
          this.mv.visitInsn(Opcodes.FSUB);
            this.mv.visitVarInsn(Opcodes.FSTORE, var);
            super.visitVarInsn(opcode, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
      } else if (opcode == Opcodes.LLOAD) {
        final MutationIdentifier newId = this.context.registerMutation(
            this.factory, "Added long decrement");
        if (this.context.shouldMutate(newId)) {
            this.mv.visitVarInsn(opcode, var);
          this.mv.visitInsn(Opcodes.LCONST_1);
          this.mv.visitInsn(Opcodes.LSUB);
            this.mv.visitVarInsn(Opcodes.LSTORE, var);
            super.visitVarInsn(opcode, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
      } else {
        super.visitVarInsn(opcode, var);
      }
  }

}