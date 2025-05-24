kill @e[tag=altarText,limit=1,sort=nearest]
scoreboard players set @s sacri.altarLevel 1
execute store result score @s sacri.altarBinding run data get entity @s UUID[0]
execute store result score @p sacri.altarBinding run data get entity @s UUID[0]
execute if entity @s[tag=sculk] as @p if score @s sacri.altarBinding = @e[tag=altar,limit=1,sort=nearest] sacri.altarBinding run advancement grant @s only sacrilege:sculk/obtain
execute as @p if score @s sacri.altarBinding = @e[tag=altar,limit=1,sort=nearest] sacri.altarBinding run advancement grant @s only sacrilege:altars/obtain
execute as @p if score @s sacri.altarBinding = @e[tag=altar,limit=1,sort=nearest] sacri.altarBinding run tag @s add sculkbinded
scoreboard players set @s sacri.altarLivingTimer 0
playsound minecraft:entity.evoker.prepare_attack player @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:item.totem.use player @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.enchantment_table.use player @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:item.lodestone_compass.lock player @a[distance=..5] ~ ~ ~ 10 0.5
particle minecraft:enchanted_hit ~ ~ ~ 0 0.2 0 0.5 100
particle minecraft:soul_fire_flame ~ ~ ~ 0 0.2 0 0.1 50
particle minecraft:end_rod ~ ~ ~ 0 0.2 0 0.1 50
tag @s add binded