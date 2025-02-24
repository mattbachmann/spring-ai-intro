package guru.springframework.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record CapitalWithInfoResponse(@JsonPropertyDescription("This is the City name") String capital,
                                      @JsonPropertyDescription("This is the City's population as a number") Integer population,
                                      @JsonPropertyDescription("This is the primary language spoken in the City") String language,
                                      @JsonPropertyDescription("This is the currency used in the City") String currency) {
}
