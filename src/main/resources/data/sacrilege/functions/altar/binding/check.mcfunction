data modify entity @e[tag=altarText,limit=1,sort=nearest] text set value '[{"text":"Are you absolutely sure?","color":"dark_aqua","bold":true,"italic":false},{"text":"\\nThere is no going back.","color":"red","italic":true},{"text":"\\n(right click again)"}]'
particle minecraft:ambient_entity_effect ~ ~ ~ 0.3 0.3 0.3 0 100
scoreboard players set @e[tag=altarDisplay,limit=1,sort=nearest] sacri.altarLevel 0
playsound minecraft:entity.evoker.prepare_summon player @a[distance=..5] ~ ~ ~ 10 0.5
data remove entity @e[tag=altarClicks,limit=1,sort=nearest] interaction
scoreboard players set @s sacri.altarBinding 1
scoreboard players set @s sacri.altarBindCooldown 3