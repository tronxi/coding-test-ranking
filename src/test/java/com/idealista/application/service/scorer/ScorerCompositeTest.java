package com.idealista.application.service.scorer;

import com.idealista.application.model.Ad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.idealista.util.TestUtil.getEmptyAd;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScorerCompositeTest {

    @Mock
    private Scorer scorer;

    @Mock
    private Scorer scorer2;

    @InjectMocks
    private ScorerComposite scorerComposite;

    @Test
    public void shouldCallAllScorers() {
        //GIVEN
        Ad ad = getEmptyAd();
        Integer expectedScore = 10;
        when(scorer.calculate(ad)).thenReturn(expectedScore);
        when(scorer2.calculate(ad)).thenReturn(expectedScore);

        //WHEN
        scorerComposite.add(scorer);
        scorerComposite.add(scorer2);
        Integer score = scorerComposite.calculate(ad);

        //THEN
        verify(scorer).calculate(ad);
        verify(scorer2).calculate(ad);
        assertEquals(new Integer(expectedScore * 2), score);
    }

    @Test
    public void shouldCallAllScorers2() {
        //GIVEN
        Ad ad = getEmptyAd();

        //WHEN
        Integer score = scorerComposite.calculate(ad);

        //THEN
        assertEquals(new Integer(0), score);
    }

}