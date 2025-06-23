data modify entity @e[tag=altarItem,limit=1,sort=nearest] item set value {id:"minecraft:player_head",Count:1b,tag:{SculkDeityItem:1b,AttributeModifiers:[{AttributeName:"generic.knockback_resistance",Name:"generic.knockback_resistance",Amount:0.1,Operation:0,UUID:[I;1358004263,703285426,-1378347980,30091162],Slot:"head"},{AttributeName:"generic.armor_toughness",Name:"generic.armor_toughness",Amount:3,Operation:0,UUID:[I;1646759752,-1451408949,-1252223470,-231207243],Slot:"head"},{AttributeName:"generic.armor",Name:"generic.armor",Amount:3,Operation:0,UUID:[I;-480026189,-919648320,-1311116921,975583185],Slot:"head"}],SkullOwner:"DanieloXXelo",BlockEntityTag:{note_block_sound:"sacrilege:devs.danieloxxelo"}}}
particle minecraft:sonic_boom ~ ~1.3 ~ 0 0 0 0 1
particle minecraft:dust 0 0 0 1 ~ ~1.3 ~ 0.5 0.5 0.5 2 100
particle minecraft:end_rod ~ ~1.3 ~ 0 0 0 0.2 20
playsound minecraft:entity.illusioner.cast_spell block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.ender_chest.open block @a[distance=..5] ~ ~ ~ 10 0.5
advancement grant @p only sacrilege:altars/offering