setblock ~ ~ ~ minecraft:crying_obsidian
playsound minecraft:block.respawn_anchor.deplete block @a ~ ~ ~ 1 0.5
particle minecraft:sonic_boom ~ ~0.5 ~ 0 0 0 1 1
summon minecraft:interaction ~ ~ ~ {Tags:["realityUnbreak"],width:1.1,height:1.1}
kill @s