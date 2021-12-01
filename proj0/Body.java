import java.lang.Math;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    
    public double calcDistance(Body body) {
        double dx = body.xxPos - this.xxPos;
        double dy = body.yyPos - this.yyPos;
        return Math.sqrt((dx*dx) + (dy*dy));
    }
    
    public double calcForceExertedBy(Body body) {
        if (this.calcDistance(body) == 0) {
            return 0.0;
        }
        return (6.67e-11 * this.mass * body.mass) / (this.calcDistance(body) * this.calcDistance(body));
    }

    public double calcForceExertedByX(Body body) {
        if (this.calcDistance(body) == 0) {
            return 0.0;
        }
        double dx = body.xxPos - this.xxPos;
        return (this.calcForceExertedBy(body) * dx) / this.calcDistance(body);
    }

    public double calcForceExertedByY(Body body) {
        if (this.calcDistance(body) == 0) {
            return 0.0;
        }
        double dy = body.yyPos - this.yyPos;
        return (this.calcForceExertedBy(body) * dy) / this.calcDistance(body);
    }

    public double calcNetForceExertedByX(Body[]array) {
        double sumX = 0;
        for (Body body: array) {
            sumX += this.calcForceExertedByX(body);
        }
        return sumX;
    }

    public double calcNetForceExertedByY(Body[]array) {
        double sumY = 0;
        for (Body body: array) {
            sumY += this.calcForceExertedByY(body);
        }
        return sumY;
    }

    public void update(double time, double xforce, double yforce) {
        double anetx = xforce / this.mass;
        double anety = yforce / this.mass;

        this.xxVel = this.xxVel + time * anetx;
        this.yyVel = this.yyVel + time * anety;

        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}