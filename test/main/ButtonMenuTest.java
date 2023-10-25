package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import button.AssociationButton;
import button.Button;
import button.ClassButton;
import button.CompositionButton;
import button.GeneralizationButton;
import button.SelectButton;
import button.UseCaseButton;

import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Component;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class ButtonMenuTest {
    private AutoCloseable closeable;
    @Mock
    Canvas mockCanvasInstance;

    @Spy
    MouseAdapter clickEvent;

    @InjectMocks
    ButtonMenu testButtonMenu;

    @Captor
    ArgumentCaptor<Integer> integerCaptor;

    @Captor
    ArgumentCaptor<Point> pointCaptor;

    @Test
    public void testConstructor() {
        // Arrange
        // Act
        // Assert
        assertEquals(1, testButtonMenu.getMouseListeners().length);
        assertSame(clickEvent, testButtonMenu.getMouseListeners()[0]);
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof ClassButton));
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof UseCaseButton));
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof AssociationButton));
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof CompositionButton));
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof GeneralizationButton));
        assertTrue(
                Arrays.asList(testButtonMenu.getComponents()).stream()
                        .anyMatch(component -> component instanceof SelectButton));
    }

    @Test
    public void testSetBtnWhite() {
        // Arrange
        Button mockButton = mock(Button.class);
        Button[] mockButtonArray = { mockButton, mockButton, mockButton };
        ButtonMenu spyButtonMenu = spy(testButtonMenu);
        doReturn(mockButtonArray).when(spyButtonMenu).getComponents();

        // Act
        spyButtonMenu.setBtnWhite();

        // Assert
        verify(mockButton, times(3)).setWhite();
    }

    // Deprecated !!
    // Since the clickEvent is an anonymous class instance,
    // and `doReturn(spyClickedButton).when(spyButtonMenu).getComponentAt(any());`
    // not work inside the class definition of clickEvent.
    // @Test
    // public void testMousePressed() {
    //     // Arrange
    //     try (MockedStatic<Canvas> mockedStaticCanvas = mockStatic(Canvas.class)) {
    //         mockedStaticCanvas.when(Canvas::getInstance).thenReturn(mockCanvasInstance);
    //         ButtonMenu notInjectedTestButtonMenu = new ButtonMenu();
    //         ButtonMenu spyButtonMenu = spy(notInjectedTestButtonMenu);
    //         Button spyClickedButton = spy(Button.class);
    //         doReturn(spyClickedButton).when(spyButtonMenu).getComponentAt(any());
    //         MouseEvent mockMouseEvent = mock(MouseEvent.class);
    //         Point p = new Point(0, 0);
    //         when(mockMouseEvent.getPoint()).thenReturn(p);
    //         // Act
    //         spyButtonMenu.clickEvent.mousePressed(mockMouseEvent);
    //         // Assert
    //         verify(mockCanvasInstance).setUnSelect();
    //         verify(spyButtonMenu).setBtnWhite();
    //         verify(spyButtonMenu, atLeastOnce()).getComponentAt(pointCaptor.capture());
    //         assertEquals(p, pointCaptor.getValue());
    //         verify(spyClickedButton).setBlack();
    //         verify(spyClickedButton).setMode();
    //     }
    // }

    @Before
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }
}