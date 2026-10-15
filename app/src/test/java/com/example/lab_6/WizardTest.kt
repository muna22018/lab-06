package com.example.lab_6

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard

    // sets up new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    // check behavior when we successfully cast an explosion spell
    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30
        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }

    // checks behavior when we don't have enough mana to cast an explosion spell
    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)
        assertEquals(5, evilWizard.mana) // mana is still 5
    }

    // check behavior when we successfully cast a frostbite spell
    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt)  // spellPower of 10 * 2 = 20
        assertEquals(25, evilWizard.mana) // mana of 30 - 5 = 25
    }

    // check behavior when we don't have enough mana to cast "Frostbite"
    @Test
    fun castSpell_frostbite_unsuccessful() {
        evilWizard.mana = 3 // Evil Wizard does not have enough mana to cast "Frostbite"
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt)
        assertEquals(3, evilWizard.mana) // mana still 3
    }

}