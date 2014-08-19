package com.uwetrottmann.trakt.v2.services;

import com.uwetrottmann.trakt.v2.BaseTestCase;
import com.uwetrottmann.trakt.v2.TestData;
import com.uwetrottmann.trakt.v2.entities.Episode;
import com.uwetrottmann.trakt.v2.entities.Season;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class SeasonsTest extends BaseTestCase {

    @Test
    public void test_summary() {
        List<Season> seasons = getTrakt().seasons().summary(TestData.SHOW_SLUG);
        assertThat(seasons).isNotEmpty();
    }

    @Test
    public void test_season() {
        List<Episode> season = getTrakt().seasons().season(TestData.SHOW_SLUG, TestData.EPISODE_SEASON);
        assertThat(season).isNotEmpty();
        for (Episode episode : season) {
            assertThat(episode.season).isEqualTo(TestData.EPISODE_SEASON);
        }
    }
}
