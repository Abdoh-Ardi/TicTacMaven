import java.awt.DisplayMode;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class Cube implements GLEventListener {
    private Objects objects=new Objects();
    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private float rquad = 0.0f;
    private int TnumTex;
    private int TwoodTex;
    private int xWood;
    private int oWood;
    private final Scanner SC= new Scanner(System.in);
    @Override
    public void display( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        gl.glLoadIdentity();
        gl.glTranslatef( 0f, 0f, -5.0f );

        // Rotate The Cube On X, Y & Z
//        gl.glRotatef(rquad, 1.0f, 1.0f, 0.0f);//change rotation direction


//        gl.glBegin(GL2.GL_QUADS);

//        gl.glTexCoord2d(1, 1);
//        gl.glVertex2d (0, 0);
//        gl.glTexCoord2d(0, 1);
//        gl.glVertex2d (1, 0);
//        gl.glTexCoord2d(0, 0);
//        gl.glVertex2d (1, 1);
//        gl.glTexCoord2d(1, 0);
//        gl.glVertex2d (0, 1);
//        gl.glEnd ();
//        System.out.println("Enter coordinates");
//        objects.cube(sc.nextFloat(),sc.nextFloat(),sc.nextFloat(),gl);
//        objects.cube(1,1,1,gl);
        objects.table(TnumTex,TwoodTex,gl);
//        objects.drawCubeAt(SC.nextFloat(),SC.nextFloat(),SC.nextFloat(),xWood,gl);
        gl.glRotatef(rquad,1f,0f,0f);//todo adjust cube rotation and record it on paper for future
        //TODO cube size is 0.4 0.4 0.4 change if necessary
        //TODO the coordinates below belong to gl.translatef change to change cube location
        objects.drawCubeAt(-1f,1f,-0.6f,oWood,gl);//coordinate is for gltranslatef(where the cube is)
        //TODO to change cube from X to O change (xWood) to (oWood)
        gl.glTranslatef( 0f, 0f, -5.0f );


        //giving different colors to different sides

//         gl.glBegin(GL2.GL_QUADS);// Start Drawing The Cube
//        objects.cube(gl);
//       objects.circle(gl);

//        objects.circle(gl);
//       objects.cubeTutorial(gl);
//        gl.glBegin(GL2.GL_LINES);

//        gl.glEnd(); // Done Drawing The Quad
        gl.glFlush();

        rquad -= 0.5f;//turns the shape by this rate//TODO remove if neccesary
    }

    @Override
    public void dispose( GLAutoDrawable drawable ) {
        // TODO Auto-generated method stub
    }

    @Override
    public void init( GLAutoDrawable drawable ) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel( GL2.GL_SMOOTH );
        gl.glClearColor( 0f, 0f, 0f, 0f );
        gl.glClearDepth( 1.0f );
        gl.glEnable( GL2.GL_DEPTH_TEST );
        gl.glDepthFunc( GL2.GL_LEQUAL );
        gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
        //AMBIENT
        float ambient[] = { 1.0f, 0.0f, 0.0f, 1.0f };

        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LESS);

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        //AMBIENT END
//        //DIFFUSE
//        float diffuse[] = { 1.0f, 0.0f, 0.0f, 1.0f };
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
//        //DIFFUSE END
//        //specularLight
//        float specular[] = { 1.0f, 0.0f, 0.0f, 1.0f };
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular,0);
//        //specularLight END
//        //PositionLight
//        float position [] = { 1.0f, 0.0f, 0.0f, 1.0f };
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);
        //PositionLight END

//        Texture texture= null;
        gl.glEnable(GL2.GL_TEXTURE_2D);
        try {
            Texture t1 = TextureIO.newTexture(new File("XWood.png"), true);
            xWood=t1.getTextureObject(gl);
//            t0.enable(gl);
//            t0.bind(gl);
            //
            Texture t2 = TextureIO.newTexture(new File("OWood.png"),true);
            oWood= t2.getTextureObject(gl);

            Texture t3 = TextureIO.newTexture(new File("TNum.jpeg"), true);
            TnumTex = t3.getTextureObject(gl);//added gl

            Texture t4 = TextureIO.newTexture(new File("TWood.jpeg"), true);
            TwoodTex = t4.getTextureObject(gl);//added gl

            //
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {

        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        if( height == 0 ){
        height = 1;
        }

        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }
    public static void main( String[] args ) {

        final GLProfile profile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities capabilities = new GLCapabilities( profile );

        // The canvas
        final GLCanvas glcanvas = new GLCanvas( capabilities );
        Cube cube = new Cube();


        glcanvas.addGLEventListener( cube );
        glcanvas.setSize( 400, 400 );
        
        final JFrame frame = new JFrame ( " Multicolored cube" );

        frame.getContentPane().add( glcanvas );
        glcanvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {



            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(KeyEvent.VK_NUMPAD1==e.getKeyCode()){
                    System.out.println("meth");
                }
                if(e.getKeyCode()==35||e.getKeyChar()=='1'){
                    System.out.println(1);
                    System.out.println();
                }else if(e.getKeyCode()==40||e.getKeyChar()=='2'){
                    System.out.println(2);
                }else if(e.getKeyCode()==34||e.getKeyChar()=='3'){
                    System.out.println(3);
                }else if(e.getKeyCode()==37||e.getKeyChar()=='4'){
                    System.out.println(4);
                }else if(e.getKeyCode()==12||e.getKeyChar()=='5'){
                    System.out.println(5);
                }else if(e.getKeyCode()==39||e.getKeyChar()=='6'){
                    System.out.println(6);
                }else if(e.getKeyCode()==36||e.getKeyChar()=='7'){
                    System.out.println(7);
                }else if(e.getKeyCode()==38||e.getKeyChar()=='8'){
                    System.out.println(8);
                }else if(e.getKeyCode()==33||e.getKeyChar()=='9'){
                    System.out.println(9);
                }


            }
        });
        //
//        frame.setFocusable(true);
            frame.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    System.out.println("welcome");
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }

                @Override
                public void windowClosed(WindowEvent e) {

                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
        //
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setVisible( true );

        final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
        animator.start();
    }


}