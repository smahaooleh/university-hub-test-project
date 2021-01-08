package osmaha.universityhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osmaha.universityhub.repository.LectorRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GlobalSearchService {

    @Autowired
    private LectorRepository lectorRepository;

    public List<String> globalSearch(String template) throws Exception {
        Optional<String> matchedLectors = lectorRepository.findByFirstNameContainingOrLastNameContainingIgnoreCase(template, template).stream()
                .map((lector) -> lector.getFirstName() + " " + lector.getLastName()).reduce((output, lectorName) -> output + ", " + lectorName);
        return new ArrayList<>(Arrays.asList(matchedLectors.orElse("There is no matches")));
    }
}
