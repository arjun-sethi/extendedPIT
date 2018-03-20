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
public enum AORMutator4 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor4(this, methodInfo, context, methodVisitor);
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

public enum AORMutator5 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor5(this, methodInfo, context, methodVisitor);
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
public enum AORMutator6 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor6(this, methodInfo, context, methodVisitor);
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
public enum AORMutator7 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor7(this, methodInfo, context, methodVisitor);
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
public enum AORMutator8 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor8(this, methodInfo, context, methodVisitor);
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
public enum AORMutator9 implements MethodMutatorFactory {

  AOR_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new AORMethodVisitor9(this, methodInfo, context, methodVisitor);
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


// SUB, ADD, DIV MUL
class AORMethodVisitor1 extends AbstractInsnMutator {

  AORMethodVisitor1(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer addition with subtraction"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer subtraction with addition"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer multiplication with division"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer division with multiplication"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long addition with subtraction"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
        "Replaced long subtraction with addition"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long multiplication with division"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long division with multiplication"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float addition with subtraction"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
        "Replaced float subtraction with addition"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float multiplication with division"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float division with multiplication"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double addition with subtraction"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
        "Replaced double subtraction with addition"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double multiplication with division"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double division with multiplication"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//MUL, DIV, ADD, SUB
class AORMethodVisitor2 extends AbstractInsnMutator {

  AORMethodVisitor2(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced float modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//DIV, MUL, SUB, ADD
class AORMethodVisitor3 extends AbstractInsnMutator {

  AORMethodVisitor3(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer division with addition"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long addition with division"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long subtraction with multiplication"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long multiplication with subtraction"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
        "Replaced long division with addition"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float addition with division"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float subtraction with multiplication"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float multiplication with subtraction"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
        "Replaced float division with addition"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double addition with division"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double subtraction with multiplication"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double multiplication with subtraction"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
        "Replaced double division with addition"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//SUB, MUL, DIV, ADD
class AORMethodVisitor4 extends AbstractInsnMutator {

  AORMethodVisitor4(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer addition with subtraction"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer multiplication with division"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer division with addition"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long addition with subtraction"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long subtraction with multiplication"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long multiplication with division"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
        "Replaced long division with addition"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float addition with subtraction"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float subtraction with multiplication"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float multiplication with division"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
        "Replaced float division with addition"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double addition with subtraction"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double subtraction with multiplication"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double multiplication with division"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
        "Replaced double division with addition"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//SUB, DIV, ADD, MUL
class AORMethodVisitor5 extends AbstractInsnMutator {

  AORMethodVisitor5(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer addition with subtraction"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer division with multiplication"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long addition with subtraction"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long subtraction with division"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD,
        "Replaced long multiplication with addition"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long division with multiplication"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float addition with subtraction"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float subtraction with division"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
        "Replaced float multiplication with addition"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float division with multiplication"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double addition with subtraction"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double subtraction with division"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
        "Replaced double multiplication with addition"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double division with multiplication"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//MUL, ADD, DIV, SUB
class AORMethodVisitor6 extends AbstractInsnMutator {

  AORMethodVisitor6(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer subtraction with addition"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer multiplication with division"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
        "Replaced long subtraction with addition"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long multiplication with division"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long division with subtraction"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
        "Replaced float subtraction with addition"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float multiplication with division"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float division with subtraction"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
        "Replaced double subtraction with addition"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double multiplication with division"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double division with subtraction"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//MUL, DIV, SUB, ADD
class AORMethodVisitor7 extends AbstractInsnMutator {

  AORMethodVisitor7(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer division with addition"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long subtraction with division"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long multiplication with subtraction"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LADD,
        "Replaced long division with addition"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float subtraction with division"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float multiplication with subtraction"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD,
        "Replaced float division with addition"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double subtraction with division"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double multiplication with subtraction"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD,
        "Replaced double division with addition"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//DIV, ADD, SUB, MUL
class AORMethodVisitor8 extends AbstractInsnMutator {

  AORMethodVisitor8(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer subtraction with addition"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer division with multiplication"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
        "Replaced long addition with division"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LADD,
        "Replaced long subtraction with addition"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
        "Replaced long multiplication with subtraction"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long division with multiplication"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
        "Replaced float addition with division"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD,
        "Replaced float subtraction with addition"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
        "Replaced float multiplication with subtraction"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float division with multiplication"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
        "Replaced double addition with division"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD,
        "Replaced double subtraction with addition"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
        "Replaced double multiplication with subtraction"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double division with multiplication"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced double modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

//DIV, MUL, ADD, SUB
class AORMethodVisitor9 extends AbstractInsnMutator {

  AORMethodVisitor9(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL,
        "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL,
        "Replaced Unsigned Shift Right with Shift Left"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced bitwise OR with AND"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LOR,
        "Replaced bitwise AND with OR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL,
        "Replaced long modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND,
        "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR,
        "Replaced Shift Left with Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Shift Right with Shift Left"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL,
        "Replaced Unsigned Shift Right with Shift Left"));


    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL,
        "Replaced float modulus with multiplication"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV,
        "Replaced integer addition with division"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DMUL,
        "Replaced integer subtraction with multiplication"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD,
        "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
        "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL,
        "Replaced float modulus with multiplication"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
