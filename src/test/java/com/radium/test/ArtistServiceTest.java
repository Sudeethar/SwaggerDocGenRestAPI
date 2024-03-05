package com.radium.test;

import com.radium.test.service.ArtistService;
import com.radium.test.repository.ArtistRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ArtistServiceTest {
    @Mock
    ArtistRepository artistRepository;

    @InjectMocks
    ArtistService artistService;

    @Test
    public void testTop1() {
        Mockito.when(artistRepository.findAll()).thenReturn(DummyData.testData());
        Assert.assertEquals("Michael Jackson", artistService.getMostProductiveArtists(1).get(0));
        Assert.assertEquals(1, artistService.getMostProductiveArtists(1).size());
    }


    @Test
    public void testTop2() {
        Mockito.when(artistRepository.findAll()).thenReturn(DummyData.testData());
        Assert.assertEquals("Michael Jackson", artistService.getMostProductiveArtists(1).get(0));
        Assert.assertEquals("Eminem", artistService.getMostProductiveArtists(2).get(1));
        Assert.assertEquals(1, artistService.getMostProductiveArtists(1).size());
    }



}
