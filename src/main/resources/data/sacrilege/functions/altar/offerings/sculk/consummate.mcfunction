loot replace entity @s weapon.mainhand loot sacrilege:offerings/sculk/consummate
data modify entity @e[tag=altarItem,limit=1,sort=nearest] item set from entity @s HandItems[0]
execute if data entity @e[tag=altarItem,limit=1,sort=nearest] {item:{id:"sacrilege:riftcaller"}} run scoreboard players set riftcallerObtained sacri.configs 1
item replace entity @s weapon.mainhand with air
particle minecraft:sonic_boom ~ ~1.3 ~ 0 0 0 0 1
particle minecraft:dust 0 0 0 1 ~ ~1.3 ~ 0.5 0.5 0.5 2 100
particle minecraft:end_rod ~ ~1.3 ~ 0 0 0 0.2 20
playsound minecraft:entity.illusioner.cast_spell block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.ender_chest.open block @a[distance=..5] ~ ~ ~ 10 0.5
advancement grant @p only sacrilege:altars/offering