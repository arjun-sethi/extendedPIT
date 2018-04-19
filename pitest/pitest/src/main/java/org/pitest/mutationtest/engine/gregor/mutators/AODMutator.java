package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class AODMutator {

  public enum AODMutator1 implements MethodMutatorFactory {

    AOD_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new AODMethodVisitor1(this, context, methodVisitor);
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
  public enum AODMutator2 implements MethodMutatorFactory {

    AOD_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new AODMethodVisitor2(this, context, methodVisitor);
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

class AODMethodVisitor1 extends MethodVisitor {
  public String symbol(int opcode)  {
    String returnValue;
    if (opcode == 96 || opcode == 97 || opcode == 98 || opcode == 99) {
      returnValue = "+";
    } else if (opcode == 100 || opcode == 101 || opcode == 102 || opcode == 103) {
      returnValue = "-";
    } else if (opcode == 104 || opcode == 105 || opcode == 106 || opcode == 107) {
      returnValue = "*";
    } else if (opcode == 108 || opcode == 109 || opcode == 110 || opcode == 111) {
      returnValue = "/";
    } else if (opcode == 112 || opcode == 113 || opcode == 114 || opcode == 115) {
      returnValue = "%";
    } else  {
      returnValue = "[arithmetic symbol]";
    }

    return returnValue;
  }

  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  AODMethodVisitor1(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {
    if (opcode == Opcodes.IADD || opcode == Opcodes.ISUB || opcode == Opcodes.IDIV || opcode == Opcodes.IMUL || opcode == Opcodes.IREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced INTEGER A " + symbol(opcode) + " B with A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FADD || opcode == Opcodes.FSUB || opcode == Opcodes.FDIV || opcode == Opcodes.FMUL || opcode == Opcodes.FREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced FLOAT A " + symbol(opcode) + " B with A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LADD || opcode == Opcodes.LSUB || opcode == Opcodes.LDIV || opcode == Opcodes.LMUL || opcode == Opcodes.LREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced LONG A " + symbol(opcode) + " B with A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.visitInsn(opcode);
      }
    }  else if (opcode == Opcodes.DADD || opcode == Opcodes.DSUB || opcode == Opcodes.DDIV || opcode == Opcodes.DMUL || opcode == Opcodes.DREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced DOUBLE A " + symbol(opcode) + " B with A");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.visitInsn(opcode);
      }
    } else {
      super.visitInsn(opcode);
    }
  }

}

class AODMethodVisitor2 extends MethodVisitor {
  public String symbol(int opcode)  {
    String returnValue;
    if (opcode == 96 || opcode == 97 || opcode == 98 || opcode == 99) {
      returnValue = "+";
    } else if (opcode == 100 || opcode == 101 || opcode == 102 || opcode == 103) {
      returnValue = "-";
    } else if (opcode == 104 || opcode == 105 || opcode == 106 || opcode == 107) {
      returnValue = "*";
    } else if (opcode == 108 || opcode == 109 || opcode == 110 || opcode == 111) {
      returnValue = "/";
    } else if (opcode == 112 || opcode == 113 || opcode == 114 || opcode == 115) {
      returnValue = "%";
    } else  {
      returnValue = "[arithmetic symbol]";
    }

    return returnValue;
  }

  private final MethodMutatorFactory factory;
  private final MutationContext      context;

  AODMethodVisitor2(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(Opcodes.ASM6, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {
    if (opcode == Opcodes.IADD || opcode == Opcodes.ISUB || opcode == Opcodes.IDIV || opcode == Opcodes.IMUL || opcode == Opcodes.IREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced INTEGER A " + symbol(opcode) + " B with B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP_X1);
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.mv.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FADD || opcode == Opcodes.FSUB || opcode == Opcodes.FDIV || opcode == Opcodes.FMUL || opcode == Opcodes.FREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced FLOAT A " + symbol(opcode) + " B with B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP_X1);
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.mv.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LADD || opcode == Opcodes.LSUB || opcode == Opcodes.LDIV || opcode == Opcodes.LMUL || opcode == Opcodes.LREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced LONG A " + symbol(opcode) + " B with B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2);
        this.mv.visitInsn(Opcodes.POP2);
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.mv.visitInsn(opcode);
      }
    }  else if (opcode == Opcodes.DADD || opcode == Opcodes.DSUB || opcode == Opcodes.DDIV || opcode == Opcodes.DMUL || opcode == Opcodes.DREM)
    {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced DOUBLE A " + symbol(opcode) + " B with B");
      if (this.context.shouldMutate(newId)) {
        this.mv.visitInsn(Opcodes.DUP2_X2);
        this.mv.visitInsn(Opcodes.POP2);
        this.mv.visitInsn(Opcodes.POP2);
      } else {
        super.mv.visitInsn(opcode);
      }
    } else {
      super.mv.visitInsn(opcode);
    }
  }

}