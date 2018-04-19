package org.pitest.mutationtest.engine.gregor.mutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import java.util.Random;
import java.util.ArrayList;
import org.objectweb.asm.Label;



/*M4 mutator
  i.e. replace a local variable by another local variable at random
  */
public class RandVarReplMutator {
  public enum RandomVarReplacement implements MethodMutatorFactory {
    RAND_VAR_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new RandomVarReplacement1(this, context, methodVisitor);
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
  class RandomVarReplacement1 extends MethodVisitor {
    private final MethodMutatorFactory factory;
    private final MutationContext      context;
    ArrayList < String > varNames = new ArrayList < String > ();
    ArrayList < Integer > varIndex = new ArrayList < Integer > ();
    ArrayList < String > varType = new ArrayList < String > ();
    ArrayList < Integer > replacments = new ArrayList < Integer > ();
    int n;

    RandomVarReplacement1(final MethodMutatorFactory factory, final MutationContext context, final MethodVisitor delegateMethodVisitor) {
      super(Opcodes.ASM6, delegateMethodVisitor);
      this.factory = factory;
      this.context = context;
    }

    @Override
    public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index) {
      if ( ! (varIndex.contains(index))) { //if new variable detected
        varNames.add(name); //save name in list of variables
        varIndex.add(index);  //save index of variable on localvar table
        varType.add(desc);  //save type of variable
      }

      if (varNames.size() > 1) { //if we have detected more than one variable so far
        Random rand = new Random();
        n = rand.nextInt(varNames.size() - 1) + 0;  //obtain a random variable from list of detected ones
        while (n == index || desc.equals(varType.get(n)))  //if random selection is the current variable OR selected one does not match type
        {
          n = rand.nextInt(varNames.size() - 1) + 0;  //select a new variable at random
        }
        replacments.add(n); //once variable has been detected, store which variable to replace this variable with
      }
    }

    public void visitVarInsn(final int opcode,final int var) {
      if (opcode == Opcodes.ILOAD && replacments.get(var) != null) { //if load detected and a replacment for this variable has been chosen
          int index = varIndex.indexOf(var);  //get index of the variable in our saved variable list
          final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced " + varType.get(index) + " " + varNames.get(index) + " with " + varType.get(replacments.get(index)) + " " + varNames.get(replacments.get(index)));
          if (this.context.shouldMutate(newId)) {
              this.mv.visitVarInsn(opcode, varIndex.get(replacments.get(index))); //find index of replacment var in our list, and use that index to find index of the replacment variable in localvar table
              this.mv.visitVarInsn(Opcodes.ISTORE, var);  //place integer that was loaded on stack from stack into local variable
              super.visitVarInsn(opcode, var);  //load new variable value onto stack for next operation to use
          } else {
              super.visitVarInsn(opcode, var);
          }
      } else if (opcode == Opcodes.LLOAD && replacments.get(var) != null) {
          int index = varIndex.indexOf(var);
          final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced " + varType.get(index) + " " + varNames.get(index) + " with " + varType.get(replacments.get(index)) + " " + varNames.get(replacments.get(index)));
          if (this.context.shouldMutate(newId)) {
              this.mv.visitVarInsn(opcode, varIndex.get(replacments.get(index))); 
              this.mv.visitVarInsn(Opcodes.LSTORE, var);
              super.visitVarInsn(opcode, var);
          } else {
              super.visitVarInsn(opcode, var);
          }
      } else if (opcode == Opcodes.FLOAD && replacments.get(var) != null) {
          int index = varIndex.indexOf(var);
          final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced " + varType.get(index) + " " + varNames.get(index) + " with " + varType.get(replacments.get(index)) + " " + varNames.get(replacments.get(index)));
          if (this.context.shouldMutate(newId)) {
              this.mv.visitVarInsn(opcode, varIndex.get(replacments.get(index))); 
              this.mv.visitVarInsn(Opcodes.FSTORE, var);
              super.visitVarInsn(opcode, var);
          } else {
              super.visitVarInsn(opcode, var);
          }
      } else if (opcode == Opcodes.DLOAD && replacments.get(var) != null) {
          int index = varIndex.indexOf(var);
          final MutationIdentifier newId = this.context.registerMutation(this.factory, "Replaced " + varType.get(index) + " " + varNames.get(index) + " with " + varType.get(replacments.get(index)) + " " + varNames.get(replacments.get(index)));
          if (this.context.shouldMutate(newId)) {
              this.mv.visitVarInsn(opcode, varIndex.get(replacments.get(index))); 
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
