data modify entity @s item set from entity @p SelectedItem
execute as @p if predicate sacrilege:offerings/sculk/repulsive run tag @e[tag=altar,limit=1,sort=nearest] add repulsive
execute as @p if predicate sacrilege:offerings/sculk/undesirable run tag @e[tag=altar,limit=1,sort=nearest] add undesirable
execute as @p if predicate sacrilege:offerings/sculk/mediocre run tag @e[tag=altar,limit=1,sort=nearest] add mediocre
execute as @p if predicate sacrilege:offerings/sculk/prodigious run tag @e[tag=altar,limit=1,sort=nearest] add prodigious
execute as @p if predicate sacrilege:offerings/sculk/consummate run tag @e[tag=altar,limit=1,sort=nearest] add consummate
item replace entity @p weapon.mainhand with minecraft:air
particle minecraft:sonic_boom ~ ~1 ~ 0 0 0 0 1
playsound minecraft:block.end_portal_frame.fill block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.respawn_anchor.charge block @a[distance=..5] ~ ~ ~ 5 0.8
tag @e[tag=altar,limit=1,sort=nearest] add offering
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarVerdictTimer 10