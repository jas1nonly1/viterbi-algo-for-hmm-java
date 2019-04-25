class MyViterbiAlgo{
  private static String[] my_states = {"Healthy", "Fever"};
  private static String[] my_observations = {"cold", "dizzy", "normal"};
  private static double[] start_prob = {0.5, 0.5};
  private static double[][] trans_prob = {{0.2, 0.8}, {0.7, 0.3}};
  private static double[][] emission_prob = {{0.2, 0.2, 0.6}, {0.1, 0.4, 0.5}};
  

  public static void main(String[] args) throws Exception {
    System.out.print("\n States are -  ");
    for (int i = 0; i < my_states.length; i++){
      System.out.print(my_states[i] + ", ");  
    }
    System.out.print("\n\n Observations are -  ");
    for (int i = 0; i < my_observations.length; i++){
      System.out.print(my_observations[i] + ", ");  
    }
    System.out.print("\n\n Start probability is -  ");
    for (int i = 0; i < my_states.length; i++){
      System.out.print(my_states[i] + ": " + start_prob[i] + ", ");  
    }
    System.out.println("\n\n Transition probability is - ");
    for (int i = 0; i < my_states.length; i++){
      System.out.print(" " + my_states[i] + ": {");
      for (int j = 0; j < my_states.length; j++){
        System.out.print("  " + my_states[j] + ": " + trans_prob[i][j] + ", ");  
      }
      System.out.println("}");
    }
    System.out.println("\n\n Emission probability is - ");
    for (int i = 0; i < my_states.length; i++){
      System.out.print(" " + my_states[i] + ": {");
      for (int j = 0; j < my_observations.length; j++){
        System.out.print("  " + my_observations[j] + ": " + emission_prob[i][j] + ", ");  
      }
      System.out.println("}");
    }
    viterbi_fwd(my_observations, my_states, start_prob, trans_prob, emission_prob);
  }
  
  
   public static void viterbi_fwd(String[] obs, String[] states, double[] start_p, double[][] trans_p, double[][] emission_p) {
    Path[] P = new Path[states.length];
    for(int state=0; state<states.length; state++){
      int[] pathArray = new int[1];
      pathArray[0] = state;
      P[state] = new Path(start_p[state], pathArray, start_p[state]);
    }
    
     for(int result=0; result<obs.length; result++){
      Path[] Q = new Path[states.length];
      for(int newState=0; newState<states.length; newState++){
        double total=0,max_value = 0;
        int[] max_arg = new int[0];
        for(int state=0; state<states.length; state++){
          double prob = P[state].prob;
          int[] vit_path = pathArray(P[state].vit_path);
          double vit_prob = P[state].vit_prob;
          double p = emission_p[state][result] * trans_p[state][newState];
          prob*= p;
          vit_prob *= p;
          total += prob;
          if(vit_prob>max_value){
            max_arg = pathArray(vit_path, newState);
            max_value = vit_prob;
          }
        }
        Q[newState] = new Path(total, max_arg, max_value);
      }
      P = Q;
    }
	
    double total = 0,max_value = 0;
    int[] max_arg = new int[0];
	
    for(int state=0; state<states.length; state++){
      double prob = P[state].prob;
      int[] vit_path = pathArray(P[state].vit_path);
      double vit_prob = P[state].vit_prob;
      total += prob;
      if(vit_prob>max_value){
        max_arg = pathArray(vit_path);
        max_value = vit_prob;
      }
    }
	System.out.print("\nResults are - ");
	System.out.println("\n-------------");
    
	System.out.print("\n Viterbi Path is - [");
    for(int i = 0; i<max_arg.length; i++){
      System.out.print(my_states[max_arg[i]] + ",");  
    }
	
	System.out.print("]\n Probability of given state is - " + total); 
	
    System.out.println("\n Total Probability of System is -  " + max_value);
    return;
  }
  
  private static class Path{
    public double prob;
    public int[] vit_path;
    public double  vit_prob;
	
    public Path(double prob, int[] vit_path, double vit_prob){
      this.prob = prob;
      this.vit_path = pathArray(vit_path);
      this.vit_prob = vit_prob;
    }
  }
  
  public static int[] pathArray(int[] p){
    int[] newPath = new int[p.length];
    for(int i=0; i<p.length; i++){
      newPath[i] = p[i];
    }
    return newPath;
  }
  
  public static int[] pathArray(int[] p, int new_p){
    int[] newPath = new int[p.length + 1];
    for(int i=0; i<p.length; i++){
      newPath[i] = p[i];
    }
    newPath[p.length] = new_p;
    return newPath;
  }
}