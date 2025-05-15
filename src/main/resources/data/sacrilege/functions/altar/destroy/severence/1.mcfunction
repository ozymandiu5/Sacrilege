playsound minecraft:entity.warden.agitated block @s ~ ~ ~ 10 0.5
effect give @s minecraft:darkness 3 255 true
effect give @s minecraft:slowness 3 255 true
execute at @e[tag=altar,limit=1,sort=nearest] run particle minecraft:ambient_entity_effect ~ ~ ~ 0.3 0.3 0.3 0 100
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarUnbinding 1
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarUnbindingTimer 10
