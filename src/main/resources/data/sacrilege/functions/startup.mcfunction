scoreboard objectives add sacri.YPos dummy
scoreboard objectives add sacri.altarBindCooldown dummy
scoreboard objectives add sacri.altarLevel dummy
scoreboard objectives add sacri.altarCircle dummy
scoreboard objectives add sacri.altarRot dummy
scoreboard objectives add sacri.eastereggs.howdoiproveit dummy
scoreboard objectives add sacri.altarVerdictTimer dummy
scoreboard objectives add sacri.altarBinding dummy
scoreboard objectives add sacri.altarUnbinding dummy
scoreboard objectives add sacri.altarUnbindingTimer dummy
scoreboard objectives add sacri.altarLivingTimer dummy

function sacrilege:main/1sectimer

tellraw @a [{"text":"OCCULT ANALECTS: ","color":"dark_aqua"},{"text":"SACRILEGE","bold":"true"},{"text":"\nCreated by the ","color":"dark_purple"},{"text":"Occult Analects Team","bold":"true","color":"dark_purple"},{"text":"\nThere's no going back.","color":"dark_red","italic":"true","bold":"true"}]