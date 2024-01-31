package nz.co.pfr.art.Music.service;

import jakarta.persistence.Tuple;
import nz.co.pfr.art.Music.entities.Artist;
import nz.co.pfr.art.Music.repository.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    Logger log = LoggerFactory.getLogger(ArtistService.class);
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<String> getMostProductiveArtists(Integer topn) {

        var artists = artistRepository.findAll();

        var artistTrackCountMap = new HashMap<String, Integer>();

        for (Artist artist : artists) {
            log.info("artist name {} cds {}", artist.getName(), artist.getCds().size());
            int trackCount = 0;
            for (int j = 0; j < artist.getCds().size(); j++) {
                var cd = artist.getCds().get(j);
                log.info("cd title {} tracks {}", cd.getTitle(), cd.getTracks().size());
                trackCount += cd.getTracks().size();

            }
            artistTrackCountMap.put(artist.getName(), trackCount);

        }

        var mostProductiveArtists = new ArrayList<String>();

        Map<String, Integer> sortedCountByDesc = sortByValue(artistTrackCountMap, false);

        mostProductiveArtists = new ArrayList<>(sortedCountByDesc.keySet());

        log.info("most productive artist is: {}", mostProductiveArtists);

        return mostProductiveArtists.subList(0, topn);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> map, final boolean order)
    {
        List<Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    public List<String> mostProductiveSQL(Integer topn) {
        List<Tuple> tuples = artistRepository.mostProductiveSQL(topn).stream().toList();
        var mostProductiveArtists = new ArrayList<String>();
        for (Tuple tuple :tuples) {
            mostProductiveArtists.add(tuple.get("name").toString());
        }

        return mostProductiveArtists;
    }
}
