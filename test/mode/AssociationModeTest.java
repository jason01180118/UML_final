package mode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.MockitoJUnitRunner;

import object.AllObject;
import object.AssociationLine;
@RunWith(MockitoJUnitRunner.class)
public class AssociationModeTest {

    @Mock
    AllObject mockAllObject;

    @Test
    public void testSetClass() {
        AssociationMode associationMode = new AssociationMode();
        try(MockedConstruction<AssociationLine> mockedUseAssociationLineConstruction = mockConstruction(AssociationLine.class)){
            
            associationMode.setClass();

            List<AssociationLine> mockedUseAssociationLineConstructionList = mockedUseAssociationLineConstruction.constructed();
            assertEquals(1, mockedUseAssociationLineConstructionList.size());
            AllObject result = associationMode.obj;
            AllObject expect = mockedUseAssociationLineConstructionList.get(0);
            assertEquals(expect, result);
        }
    }
}

