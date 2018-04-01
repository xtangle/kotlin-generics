package com.rbc.rbcone.studygroup.kotlin.assignment.problems

fun main(args: Array<String>) {

    /**
     * Add two keywords anywhere inside the AmmoMagazine class to make the following uncommented code compile.
     */

    /*
    Gun(AmmoMagazine.newNormalBulletMag()).apply {
        releaseAmmoMag()
        reload(AmmoMagazine.newExplosiveBulletMag())
    }
    */

    /**
     * Can AmmoMagazine be modified to have functionality to reload bullets? If not, why?
     *
     * Add the functions 'hasBullets' and 'giveNextBullet' to the AmmoMagazine class, and
     * the functions 'hasAmmo' and 'shoot' to the Gun class to make the following tests pass.
     * Try to use the 'also' function in your implementation of 'giveNextBullet'.
     */

    /*
    AmmoMagazine.newExplosiveBulletMag().apply {
        hasBullets() shouldBe true
        repeat(6) { giveNextBullet() shouldBe ExplosiveBullet() }
        hasBullets() shouldBe false
        giveNextBullet() shouldBe null
    }

    Gun(AmmoMagazine.newNormalBulletMag()).apply {
        hasAmmo() shouldBe true
        repeat(12) { shoot() shouldBe NormalBullet() }
        hasAmmo() shouldBe false
        shoot() shouldBe null
    }
    */
}

sealed class Bullet
object NormalBullet: Bullet()
object ExplosiveBullet: Bullet()

class AmmoMagazine<T: Bullet>(val bullets: MutableList<T>) {
    companion object {
        fun newNormalBulletMag() = AmmoMagazine(MutableList(12) { _ -> NormalBullet })
        fun newExplosiveBulletMag() = AmmoMagazine(MutableList(6) { _ -> ExplosiveBullet })
    }
}

class Gun(private var ammoMag: AmmoMagazine<Bullet>? = null) {
    fun reload(ammoMagaine: AmmoMagazine<Bullet>) {
        if (ammoMag == null) {
            ammoMag = ammoMagaine
        }
    }
    fun releaseAmmoMag() {
        ammoMag = null
    }
}
