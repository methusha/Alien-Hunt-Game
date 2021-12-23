/*
 * Alien Class == An abstract class to provide the appropriate attributes to its child classes. The
 *                Object class's toString method is overriden here to provide more relevant details
 *                of Alien objects.
 *
 * @author methusha.jeyalingam
 * @version 1.8.0_181
 * @since 1.8
 */

package com.example.alien_hunt;

public abstract class Alien {

    private int eyes;
    protected String planet;
    protected String galaxy;

    /**
     * Alien constructor to define the appropriate attributes of an Alien object
     *
     * @param eyes      the quantity of eyes the Alien has
     * @param planet    the planet the Alien originates from
     * @param galaxy    the galaxy the Alien originates from
     */

    public Alien(int eyes, String planet, String galaxy) {
        this.eyes = eyes;
        this.planet = planet;
        this.galaxy = galaxy;
    }

    /**
     * Override the Object class's toString() method to return a more relevant String containing
     * attribute information of the Alien object
     *
     * @return a string indicating the attributes of the Alien
     */

    @Override
    public String toString() {
        return "This alien is from " + this.planet + " in the " + this.galaxy + " galaxy." +
                " It has " + this.eyes + " eyes.";
    }
}

