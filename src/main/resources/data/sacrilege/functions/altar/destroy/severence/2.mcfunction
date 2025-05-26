playsound minecraft:entity.warden.angry block @s ~ ~ ~ 10 0.5
playsound minecraft:entity.wither.hurt block @s ~ ~ ~ 10 0.5
effect give @s minecraft:darkness 5 255 true
effect give @s minecraft:slowness 5 255 true
effect give @s minecraft:mining_fatigue 5 255 true
effect give @s minecraft:weakness 5 255 true
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:soul_fire_flame ~ ~0.5 ~ 0 0.5 0 0.05 50
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:ambient_entity_effect ~ ~ ~ 0.3 0.3 0.3 0 100
execute if entity @s[tag=sculkbinded] run title @s title {"text":"STOP.","color":"dark_aqua","bold":true,"italic":true}
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarUnbinding 2
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarUnbindingTimer 10