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
import object.Classes;
import object.UseCase;
@RunWith(MockitoJUnitRunner.class)
public class UseCaseModeTest {

    @Mock
    AllObject mockAllObject;
    AllObject mockClassObject = new Classes(10, 20);
    @Test
    public void testSetClass() {
        UseCaseMode classMode = new UseCaseMode();
        try(MockedConstruction<UseCase> mockedUseCaseConstruction = mockConstruction(UseCase.class)){
            
            classMode.setClass(10, 20);

            List<UseCase> mockedUseCaseConstructionList = mockedUseCaseConstruction.constructed();
            assertEquals(1, mockedUseCaseConstructionList.size());
            AllObject result = classMode.obj;
            AllObject expect = mockedUseCaseConstructionList.get(0);
            assertEquals(expect, result);
        }
    }
}

