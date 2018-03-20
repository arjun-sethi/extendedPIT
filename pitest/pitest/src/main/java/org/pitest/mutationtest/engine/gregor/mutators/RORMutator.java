package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class RORMutator {
  public enum RORMutator1 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
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
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
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
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
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
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
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
  public enum RORMutator5 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new RORMethodVisitor5(this, context, methodVisitor);
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
  public enum RORMutator6 implements MethodMutatorFactory {

    ROR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new RORMethodVisitor6(this, context, methodVisitor);
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

//!=  ==  >=  > < <=
class RORMethodVisitor1 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "!= ==  >=  > < <=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
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

//!=  ==  <=  < > >=
class RORMethodVisitor2 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "!= ==  <=  < > >=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFGE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
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
//<=  < >=  > ==  !=
class RORMethodVisitor3 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "<= < >=  > ==  !=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFNE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
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
//>=  > !=  ==  <=  <
class RORMethodVisitor4 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = ">= > !=  ==  <=  <";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLT, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
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
//> >=  ==  !=  < <=
class RORMethodVisitor5 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = ">  >=  ==  !=  < <=";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFEQ, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFLE, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
  }

  RORMethodVisitor5(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
//< <=  > >=  !=  ==
class RORMethodVisitor6 extends AbstractJumpMutator {

  private static final String                     DESCRIPTION = "<  <=  > >=  !=  ==";
  private static final Map<Integer, Substitution> MUTATIONS   = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IFEQ, new Substitution(Opcodes.IFLT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNE, new Substitution(Opcodes.IFLE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLT, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFLE, new Substitution(Opcodes.IFGE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGE, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(Opcodes.IFGT, new Substitution(Opcodes.IFEQ, DESCRIPTION));

    MUTATIONS.put(Opcodes.IFNULL, new Substitution(Opcodes.IFNONNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IFNONNULL, new Substitution(Opcodes.IFNULL,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPNE, new Substitution(Opcodes.IF_ICMPEQ,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPEQ, new Substitution(Opcodes.IF_ICMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLE, new Substitution(Opcodes.IF_ICMPGT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGE, new Substitution(Opcodes.IF_ICMPLT,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPGT, new Substitution(Opcodes.IF_ICMPLE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ICMPLT, new Substitution(Opcodes.IF_ICMPGE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPEQ, new Substitution(Opcodes.IF_ACMPNE,DESCRIPTION));
    MUTATIONS.put(Opcodes.IF_ACMPNE, new Substitution(Opcodes.IF_ACMPEQ,DESCRIPTION));
  }

  RORMethodVisitor6(final MethodMutatorFactory factory,
      final MutationContext context, final MethodVisitor delegateMethodVisitor) {
    super(factory, context, delegateMethodVisitor);
  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}