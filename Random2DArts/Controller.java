package Random2DArts;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.security.SecureRandom;

public class Controller {

    @FXML
    private RadioButton circleRadioButton;
    @FXML
    private RadioButton ecllipseRadioButton;
    @FXML
    private RadioButton rectangleRadioButton;
    @FXML
    private ToggleGroup shapeToggleGroup;


    @FXML Pane pane1;
    @FXML Pane pane;

    private SecureRandom random = new SecureRandom();

    private int n;
    private int[] dx;
    private int[] dy;
    public void initialize() {
        n = random.nextInt(50) + 1;
        dx = new int[n];
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            Circle circle = new Circle();
            circle.setCenterX(random.nextInt(500) + 201);
            circle.setCenterY(random.nextInt(300) + 201);
            circle.setRadius(random.nextInt(100));
            circle.setFill(randomColor());
            circle.setStrokeWidth(random.nextInt(20));
            circle.setStroke(randomColor());
            pane.getChildren().add(circle);
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);
        }
        for (int i = 0; i < n; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(random.nextInt(500)+201);
            rectangle.setY(random.nextInt(300)+201);
            rectangle.setHeight(random.nextInt(200)+200);
            rectangle.setWidth(random.nextInt(400)+100);
            rectangle.setFill(randomColor());
            rectangle.setStrokeWidth(random.nextInt(30));
            rectangle.setStroke(randomColor());
           pane.getChildren().add(rectangle);
                   
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);
        }

        for (int i =0; i<n;i++){
            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(random.nextInt(800)+100);
            ellipse.setCenterY(random.nextInt(200)+200);
            ellipse.setRadiusX(random.nextInt(100)+90);
            ellipse.setRadiusY(random.nextInt(200)+ 80);
            ellipse.setStrokeWidth(random.nextInt(30));
            ellipse.setStroke(randomColor());

            ellipse.setFill(randomColor());
            pane1.getChildren().add(ellipse);

            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);

        }


        Timeline timelineAnimation2 = new Timeline(
                new KeyFrame(Duration.millis(10), e -> moveEcllipse())
        );
        timelineAnimation2.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation2.play();


//
//        Timeline timelineAnimation3 = new Timeline(
//                new KeyFrame(Duration.millis(10), e -> moveRectangles())
//        );
//        timelineAnimation3.setCycleCount(Timeline.INDEFINITE);
//        timelineAnimation3.play();

//
        Timeline timelineAnimation1 = new Timeline(
                new KeyFrame(Duration.millis(10), e -> moveCircles())
        );
        timelineAnimation1.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation1.play();

//        shapeToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
//            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
//
//                if (shapeToggleGroup.getSelectedToggle() == circleRadioButton) {
//
//                    System.out.println(shapeToggleGroup.getSelectedToggle().getUserData().toString());
//                    // Do something here with the userData of newly selected radioButton
//
//                }
//
//                else if (shapeToggleGroup.getSelectedToggle() == rectangleRadioButton) {
//
//                    System.out.println(shapeToggleGroup.getSelectedToggle().getUserData().toString());
//                    // Do something here with the userData of newly selected radioButton
//
//                }
//                else if (shapeToggleGroup.getSelectedToggle() == ecllipseRadioButton) {
//
//                    System.out.println(shapeToggleGroup.getSelectedToggle().getUserData().toString());
//                    // Do something here with the userData of newly selected radioButton
//
//                }
//
//            }
//        });


//        if(shapeToggleGroup.getSelectedToggle().equals(circleRadioButton)){
//            System.out.println("Circle is selected");
//            Timeline timelineAnimation = new Timeline(
//                    new KeyFrame(Duration.millis(10), e -> moveCircles())
//            );
//            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
//            timelineAnimation.play();
//
//        }
//
//        else if(shapeToggleGroup.getSelectedToggle().equals(ecllipseRadioButton)){
//            System.out.println("e is selected");
//            Timeline timelineAnimation = new Timeline(
//                    new KeyFrame(Duration.millis(10), e -> moveEcllipse())
//            );
//            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
//            timelineAnimation.play();
//
//
//        }
//
//        else if(shapeToggleGroup.getSelectedToggle().equals(rectangleRadioButton)){
//            System.out.println("r is selected");
//            Timeline timelineAnimation = new Timeline(
//                    new KeyFrame(Duration.millis(10), e -> moveRectangles())
//            );
//            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
//            timelineAnimation.play();
//
//        }

    }

    private void moveEcllipse() {
        for (int i = 0; i < pane1.getChildren().size(); i++) {
            Ellipse c = (Ellipse) pane1.getChildren().get(i);
            c.setCenterX(c.getCenterX() + dx[i]);
            c.setCenterY(c.getCenterY() + dy[i]);
            if (c.getCenterX() + c.getRadiusX() > pane1.getWidth() || c.getCenterX() - c.getRadiusX() < 0) dx[i] = -dx[i];
            if (c.getCenterY() + c.getRadiusY() > pane1.getHeight() || c.getCenterY() - c.getRadiusY() < 0) dy[i] = -dy[i];
        }

    }

    private void moveRectangles() {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Rectangle c = (Rectangle) pane.getChildren().get(i);
            c.setWidth(c.getX() + dx[i]);
            c.setHeight(c.getY() + dy[i]);
            if (c.getWidth() > pane.getWidth() || c.getX()  < 0) dx[i] = -dx[i];
            if (c.getHeight() > pane.getHeight() || c.getY() < 0) dy[i] = -dy[i];
        }
    }

    private void moveCircles() {
        for (int i = 0; i < pane1.getChildren().size(); i++) {
            Circle c = (Circle) pane1.getChildren().get(i);
            c.setCenterX(c.getCenterX() + dx[i]);
            c.setCenterY(c.getCenterY() + dy[i]);
            if (c.getCenterX() + c.getRadius() > pane1.getWidth() || c.getCenterX() - c.getRadius() < 0) dx[i] = -dx[i];
            if (c.getCenterY() + c.getRadius() > pane1.getHeight() || c.getCenterY() - c.getRadius() < 0) dy[i] = -dy[i];
        }
    }
    private Color randomColor(){
        return Color.rgb(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256),
            (double) random.nextInt(101) / 100);
    }
}