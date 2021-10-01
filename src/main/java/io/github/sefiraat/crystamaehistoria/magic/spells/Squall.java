package io.github.sefiraat.crystamaehistoria.magic.spells;

import io.github.sefiraat.crystamaehistoria.magic.SpellCastInformation;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.Spell;
import io.github.sefiraat.crystamaehistoria.magic.spells.core.SpellCoreBuilder;
import lombok.NonNull;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Squall extends Spell {

    public Squall() {
        SpellCoreBuilder spellCoreBuilder = new SpellCoreBuilder(2000, true, 0, false, 10, true)
                .makeInstantSpell(this::cast);
        setSpellCore(spellCoreBuilder.build());
    }

    public void cast(@NonNull SpellCastInformation spellCastInformation) {
        Player caster = spellCastInformation.getCaster();
        caster.getWorld().setThundering(true);
        caster.getWorld().setStorm(true);
        displayParticleEffect(caster, Particle.ELECTRIC_SPARK, 2, 30);
        caster.getWorld().playEffect(caster.getLocation(), Effect.BONE_MEAL_USE, 1);
    }
}
