package org.products.Dtos.response;

import org.products.Dtos.TokenPair;
import org.products.entities.User;

public record DataAndTokensResponse(User user, TokenPair tokens) {
}
