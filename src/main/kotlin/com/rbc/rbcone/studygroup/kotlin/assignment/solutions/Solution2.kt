package com.rbc.rbcone.studygroup.kotlin.assignment.solutions

import io.kotlintest.shouldBe

fun main(args: Array<String>) {

    /**
     * Add two keywords anywhere inside the AmmoMagazine class to make the following uncommented code compile.
     */

    Gun(AmmoMagazine.newNormalBulletMag()).apply {
        releaseAmmoMag()
        reload(AmmoMagazine.newExplosiveBulletMag())
    }

    /**
     * Can AmmoMagazine be modified to have functionality to reload bullets? If not, why?
     *
     * Add the functions 'hasBullets' and 'giveNextBullet' to the AmmoMagazine class, and
     * the functions 'hasAmmo' and 'shoot' to the Gun class to make the following tests pass.
     * Try to use the 'also' function in your implementation of 'giveNextBullet'.
     */

    /**
     * AmmoMagazine cannot have reload functionality because T is declared as covariant (in the 'out' position)
     * and thus cannot appear as a type in a function parameter. To see why, suppose we are allowed to have this
     * functionality. Then there is no stopping us from reloading an ExplosiveBullet into a NormalBullet AmmoMagazine,
     * or vice versa.
     */

    AmmoMagazine.newExplosiveBulletMag().apply {
        hasBullets() shouldBe true
        repeat(6) { giveNextBullet() shouldBe ExplosiveBullet }
        hasBullets() shouldBe false
        giveNextBullet() shouldBe null
    }

    Gun(AmmoMagazine.newNormalBulletMag()).apply {
        hasAmmo() shouldBe true
        repeat(12) { shoot() shouldBe NormalBullet }
        hasAmmo() shouldBe false
        shoot() shouldBe null
    }
}

sealed class Bullet
object NormalBullet : Bullet()
object ExplosiveBullet : Bullet()

class AmmoMagazine<out T : Bullet>(private val bullets: MutableList<T>) {
    companion object {
        fun newNormalBulletMag() = AmmoMagazine(MutableList(12) { _ -> NormalBullet })
        fun newExplosiveBulletMag() = AmmoMagazine(MutableList(6) { _ -> ExplosiveBullet })
    }

    fun hasBullets(): Boolean = bullets.isNotEmpty()
    fun giveNextBullet(): T? = bullets.firstOrNull()?.also { bullets.removeAt(0) }
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

    fun hasAmmo(): Boolean = ammoMag?.hasBullets() ?: false
    fun shoot(): Bullet? = ammoMag?.giveNextBullet()
}
