playsound minecraft:entity.warden.roar block @s ~ ~ ~ 10 0.5
playsound minecraft:entity.wither.death block @s ~ ~ ~ 10 0.5
playsound minecraft:block.respawn_anchor.deplete block @s ~ ~ ~ 10 0.5
effect give @s minecraft:darkness 2 255 true
effect give @s minecraft:nausea 7 255 true
effect give @s minecraft:mining_fatigue 60 1 true
effect give @s minecraft:weakness 60 1 true
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:soul_fire_flame ~ ~0.5 ~ 0 0.5 0 0.1 50
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:campfire_signal_smoke ~ ~0.5 ~ 0 0.5 0 0.1 50
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:poof ~ ~0.5 ~ 0 0.5 0 0.5 50
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:ambient_entity_effect ~ ~ ~ 0.3 0.3 0.3 0 100
execute at @e[tag=altar,limit=1,sort=nearest] run summon armor_stand ~ ~ ~ {Invisible:1b,Small:1b,Tags:["reality"]}
execute store result score @e[tag=reality,limit=1,sort=nearest] sacri.altarLivingTimer run scoreboard players get @e[tag=altar,limit=1,sort=nearest] sacri.altarLivingTimer
advancement grant @s only sacrilege:altars/severence/severence
execute if entity @s[tag=sculkbinded] as @e[tag=altar,tag=sculk,limit=1,sort=nearest] at @s run function sacrilege:altar/destroy/unbinded/sculk
execute if entity @s[tag=sculkbinded] run tag @s remove sculkbinded