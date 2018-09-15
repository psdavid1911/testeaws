package Matematica;

import java.util.ArrayList;
import java.util.HashMap;

public class RegressaoExponencial{

    HashMap<String, Double> coef=new HashMap<>(); // Coeficientes
    ArrayList<Double> x_axis;

    public RegressaoExponencial( ArrayList<Double> x_axis, ArrayList<Double> y_axis ){
        this.x_axis=x_axis;
        double xsum=0;
        double ysum=0;
        double xysum=0;                                   //variables for sums/sigma of xi,yi,xi^2,xiyi etc
        double x2sum=0;
        int n=x_axis.size();    //find out the size of the arraylist(to know the no. of data points entered)
        double y[]=new double[n];     //create an array where we will store ln(yi)
        for( int i=0; i < n; i++ )
            y[i]=Math.log(y_axis.get(i)); //Calculate the values of ln(yi)
        for( int i=0; i < n; i++ ){
            xsum=x_axis.get(i) + xsum;     //calculate sigma(xi)
            ysum=y[i] + ysum;                                  //calculate sigma(yi)
            xysum=x_axis.get(i) * y[i] + xysum;            //calculate sigma(xi*yi)
            x2sum=x_axis.get(i) * x_axis.get(i) + x2sum;   //calculate sigma(x^2i)
        }
        double a=(n * xysum - xsum * ysum) / (n * x2sum - xsum * xsum);               //calculate slope(or the the power of exp)
        double b=(x2sum * ysum - xsum * xysum) / (x2sum * n - xsum * xsum);           //calculate intercept
        double c=Math.exp(b);                                           //since b=ln(c)
        coef.put("slope", a);
        coef.put("intercept", b);
        coef.put("c", c);
    }

    public Double getY( Double x ){
        return coef.get("c") * Math.pow(Math.E, coef.get("slope") * x);
    }

    public ArrayList<Double> getY_axis(){
        ArrayList<Double> l=new ArrayList<>();
        for( Double x:x_axis )
            l.add(getY(x));
        return l;
    }
}
