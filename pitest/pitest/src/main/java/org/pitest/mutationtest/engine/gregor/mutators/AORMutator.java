package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public class AORMutator  {
  public enum AORMutator1 implements MethodMutatorFactory {

    AOR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new AORMethodVisitor1(this, methodInfo, context, methodVisitor);
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
  public enum AORMutator2 implements MethodMutatorFactory {

    AOR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new AORMethodVisitor2(this, methodInfo, context, methodVisitor);
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
  public enum AORMutator3 implements MethodMutatorFactory {

    AOR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new AORMethodVisitor3(this, methodInfo, context, methodVisitor);
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
// MUL, MUL, ADD, ADD, ADD
class AORMethodVisitor1 extends AbstractInsnMutator {

  AORMethodVisitor1(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer division with addition"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer modulus with addition"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long subtraction with multiplication"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD,
        "Replaced long multiplication with addition"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
        "Replaced long division with addition"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LADD,
        "Replaced long modulus with addition"));

    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float subtraction with multiplication"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
        "Replaced float multiplication with addition"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
        "Replaced float division with addition"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FADD,
        "Replaced float modulus with addition"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double subtraction with multiplication"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
        "Replaced double multiplication with addition"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
        "Replaced double division with addition"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DADD,
        "Replaced double modulus with addition"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//DIV, DIV, SUB, SUB, SUB
class AORMethodVisitor2 extends AbstractInsnMutator {

  AORMethodVisitor2(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer modulus with subtraction"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long modulus with subtraction"));

    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float modulus with subtraction"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DSUB,
        "Replaced float modulus with subtraction"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//MOD, MOD, MOD, MOD, DIV
class AORMethodVisitor3 extends AbstractInsnMutator {

  AORMethodVisitor3(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMOD,
        "Replaced integer addition with modulus"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMOD,
        "Replaced integer subtraction with modulus"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IMOD,
        "Replaced integer multiplication with modulus"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMOD,
        "Replaced integer division with modulus"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer modulus with division"));

    // longs
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMOD,
        "Replaced long addition with modulus"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMOD,
        "Replaced long subtraction with modulus"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LMOD,
        "Replaced long multiplication with modulus"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMOD,
        "Replaced long division with modulus"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long modulus with division"));

    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMOD,
        "Replaced float addition with modulus"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMOD,
        "Replaced float subtraction with modulus"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FMOD,
        "Replaced float multiplication with modulus"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMOD,
        "Replaced float division with modulus"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float modulus with division"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMOD,
        "Replaced double addition with modulus"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMOD,
        "Replaced double subtraction with modulus"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DMOD,
        "Replaced double multiplication with modulus"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMOD,
        "Replaced double division with modulus"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double modulus with division"));
  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}