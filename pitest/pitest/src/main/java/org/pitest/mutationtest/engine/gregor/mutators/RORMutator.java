package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.classinfo.ClassByteArraySource;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class RORMutator {
  public enum RORMutator1 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
      return new RORMethodVisitor1(this, context, methodVisitor);
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
  public enum RORMutator2 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
      return new RORMethodVisitor2(this, context, methodVisitor);
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
  public enum RORMutator3 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
      return new RORMethodVisitor3(this, context, methodVisitor);
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
  public enum RORMutator4 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor, ClassByteArraySource byteSource) {
      return new RORMethodVisitor4(this, context, methodVisitor);
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

//== to > , != to > , < to > , <= to != , >= to > , > to !=
class RORMethodVisitor1 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "Replacments: == to > , != to > , < to > , <= to != , >= to > , > to !=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFNE, DESCRIPTION));
  }

  RORMethodVisitor1(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
//== to < , != to < , < to != , <= to < , >= to != , > to <
class RORMethodVisitor2 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "Replacments: == to < , != to < , < to != , <= to < , >= to != , > to <";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLT, DESCRIPTION));
  }

  RORMethodVisitor2(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
//== to >= , != to >= , < to == , <= to >= , >= to == , > to >=
class RORMethodVisitor3 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "Replacments: == to >= , != to >= , < to == , <= to >= , >= to == , > to >=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFGE, DESCRIPTION));
  }

  RORMethodVisitor3(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
//== to <= , != to <= , < to <= , <= to == , >= to <= , > to ==
class RORMethodVisitor4 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "Replacments: == to <= , != to <= , < to <= , <= to == , >= to <= , > to ==";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFEQ, DESCRIPTION));
  }

  RORMethodVisitor4(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}