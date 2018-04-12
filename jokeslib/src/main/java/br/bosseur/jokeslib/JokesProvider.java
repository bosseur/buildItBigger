package br.bosseur.jokeslib;

import java.util.Random;

public class JokesProvider {
  private String[] mJokes = {
      "Een dwerg loopt een bar binnen\n"
          + "- Wat is blauw en ruikt naar rode verf?\n"
          + "- Blauwe verf!",
      "De jood tegen een meisje in de disco.\n"
          + "- Heb je een beetje jood in je?\n"
          + "- Nee!\n"
          + "- Wil je dat?",
      "Het hypochondrie-congres is geannuleerd wegens ziekte.",
      "Je hebt het in je hand. Het is stijf, en nu heb je het in je mond. Plotseling komt er iets"
          + " uit je mond. Je bent blij, je lacht en je legt de tandenborstel terug op de plank!"
  };
  private Random mRandom;

  public JokesProvider() {
    mRandom = new Random();
  }

  public Joke getRandonJoke() {
    return new Joke(mJokes[mRandom.nextInt(mJokes.length)]);
  }
}
