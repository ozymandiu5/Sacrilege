data modify entity @s Rotation[0] set from entity @e[tag=altar,limit=1,sort=nearest] Rotation[0]
execute store result score @s sacri.altarRot run data get entity @s Rotation[0]
scoreboard players add @s sacri.altarRot 180
execute store result entity @s Rotation[0] float 1 run scoreboard players get @s sacri.altarRot