package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompositeScorerTest {

    @Mock
    private Scorer scorer;

    @Mock
    private Scorer scorer2;

    @InjectMocks
    private CompositeScorer compositeScorer;

    @Test
    public void shouldCallAllScorers() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 10;
        when(scorer.calculate(ad)).thenReturn(expectedScore);
        when(scorer2.calculate(ad)).thenReturn(expectedScore);

        //WHEN
        compositeScorer.add(scorer);
        compositeScorer.add(scorer2);
        Integer score = compositeScorer.calculate(ad);

        //THEN
        verify(scorer).calculate(ad);
        verify(scorer2).calculate(ad);
        assertEquals(new Integer(expectedScore * 2), score);
    }

    @Test
    public void shouldReturnZeroWhenScorerIsEmpty() {
        //GIVEN
        Ad ad = getEmptyAd();

        //WHEN
        Integer score = compositeScorer.calculate(ad);

        //THEN
        assertEquals(new Integer(0), score);
    }

}