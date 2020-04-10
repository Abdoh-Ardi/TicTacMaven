//import com.jogamp.opengl.util.Animator;
//import com.jogamp.opengl.util.gl2.GLUT;
////import com.sun.opengl.util.Animator;
//import java.awt.Frame;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.util.Scanner;
//import javax.media.opengl.GL;
//import javax.media.opengl.GL2;
//import javax.media.opengl.GLAutoDrawable;
////import javax.media.opengl.GLCanvas;
//import javax.media.opengl.GLEventListener;
//import javax.media.opengl.awt.GLCanvas;
//import javax.media.opengl.glu.GLU;
////import com.sun.opengl.util.GLUT;
//public class Main implements GLEventListener {
//    double angle = 0;
//    public static void main(String[] args) {
//        Frame frame = new Frame("Simple JOGL Application");
//        GLCanvas canvas = new GLCanvas();
//        canvas.addGLEventListener(new Main());
//        frame.add(canvas);
//        frame.setSize(640, 480);
//        final Animator animator = new Animator(canvas);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                // Run this on another thread than the AWT event queue to
//                // make sure the call to Animator.stop() completes before
//                // exiting
//                new Thread(new Runnable() {
//                    public void run() {
//                        animator.stop();
//                        System.exit(0);
//                    }
//                }).start();
//            }
//        });
//        // Center frame
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        animator.start();
//    }
//    public void init(GLAutoDrawable drawable) {
//        // Use debug pipeline
//        // drawable.setGL(new DebugGL(drawable.getGL()));
//        GL2 gl = drawable.getGL().getGL2();
//        System.err.println("INIT GL IS: " + gl.getClass().getName());
//        // Enable VSync
//        gl.setSwapInterval(1);
//        // Setup the drawing area and shading mode
//        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//        gl.glShadeModel(GL2.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
//        float ambient[] = { 1.0f, 0.0f, 0.0f, 1.0f };
//
//        gl.glEnable(GL.GL_DEPTH_TEST);
//        gl.glDepthFunc(GL.GL_LESS);
//
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
//        gl.glEnable(GL2.GL_LIGHTING);
//        gl.glEnable(GL2.GL_LIGHT0);
//
//    }
//
//    @Override
//    public void dispose(GLAutoDrawable glAutoDrawable) {
//
//    }
//
//    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
//        GL2 gl = drawable.getGL().getGL2();
//        GLU glu = new GLU();
//        if (height <= 0) { // avoid a divide by zero error!
//            height = 1;
//        }
//        final float h = (float) width / (float) height;
//        gl.glViewport(0, 0, width, height);
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//        glu.gluPerspective(45.0f, h, 1.0, 20.0);
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//    }
//    public void display(GLAutoDrawable drawable) {
//        GL2 gl = drawable.getGL().getGL2();
//        GLUT glut = new GLUT();
//        Objects objects=new Objects();
//        Scanner sc=new Scanner(System.in);
//        // Clear the drawing area
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
//        // Reset the current matrix to the "identity"
//        gl.glLoadIdentity();
//        // Move the "drawing cursor" around
//        gl.glTranslatef(0.0f, 0.0f, -6.0f);
//        angle += 2;
//        gl.glRotated(angle, 0, 1, 0);
////        glut.glutSolidTeapot(1);
//        objects.cube(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),gl);
//        // Flush all drawing operations to the graphics card
//        gl.glFlush();
//    }
//    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean
//            deviceChanged) {
//    }
//}
