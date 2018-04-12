package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import br.bosseur.jokeslib.Joke;
import br.bosseur.jokeslib.JokesProvider;

/** An endpoint class we are exposing */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com"
        )
)
public class MyEndpoint {

    private JokesProvider mJokesProvider = new JokesProvider();

    @ApiMethod(name = "tellJoke")
    public Joke tellJoke() {
        return mJokesProvider.getRandonJoke();
    }

}
