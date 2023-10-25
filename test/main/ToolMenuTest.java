package main;

import item.GroupItem;
import item.SetNameItem;
import item.UnGroupItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ToolMenuTest {
    @Test
    public void testConstructor() {
        // Arrange
        // Act
        ToolMenu testToolMenu = new ToolMenu();
        // Assert
        List<Component> menuList = Arrays.asList(testToolMenu.getComponents());
        assertTrue(menuList.stream()
                .anyMatch(component -> component instanceof JMenu && ((JMenu) component).getText().equals("File")));
        assertTrue(menuList.stream()
                .anyMatch(component -> component instanceof JMenu && ((JMenu) component).getText().equals("Edit")));
        Component editMenu = menuList.stream()
                .filter(component -> component instanceof JMenu && ((JMenu) component).getText().equals("Edit")).findAny()
                .get();
        List<Component> editMenuItemList = new ArrayList<>();
        for (int i = 0; i < ((JMenu) editMenu).getItemCount(); i++) {
            editMenuItemList.add(((JMenu) editMenu).getItem(i));
        }
        assertTrue(editMenuItemList.stream().anyMatch(component -> component instanceof GroupItem));
        assertTrue(editMenuItemList.stream().anyMatch(component -> component instanceof UnGroupItem));
        assertTrue(editMenuItemList.stream().anyMatch(component -> component instanceof SetNameItem));
    }
}
