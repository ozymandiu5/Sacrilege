effect give @s minecraft:slow_falling 2 0 true
effect give @s minecraft:darkness 5 0 true
effect give @s minecraft:weakness 2 255 true
effect give @s minecraft:mining_fatigue 2 4 true
execute if score @s sacri.YPos matches ..-230 in minecraft:overworld run tp @s ~ 384 ~
execute if score @s sacri.YPos matches ..-230 in minecraft:overworld run playsound minecraft:entity.warden.sonic_boom player @s ~ ~ ~ 10 0.5
execute if score @s sacri.YPos matches ..-230 in minecraft:overworld run effect give @s minecraft:slow_falling 45 1 true
execute if score @s sacri.YPos matches ..-230 in minecraft:overworld run tag @s remove expurgated