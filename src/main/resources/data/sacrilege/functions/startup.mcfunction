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
scoreboard objectives add sacri.altarCultAdd dummy

scoreboard objectives add sacri.configs dummy
execute unless score riftcallerObtained sacri.configs matches 1 run scoreboard players set riftcallerObtained sacri.configs 0

function sacrilege:main/1sectimer

tellraw @a ["",{"text":"OCCULT ANALECTS:","bold":true,"color":"dark_purple"},{"text":" ","bold":true,"color":"dark_green"},{"text":"SACRILEGE ","bold":true,"color":"dark_aqua"},"\n",{"text":"LOADED SUCCESFULLY!","color":"white","bold":true},"\n",{"text":"Thanks for downloading! There Is No Going Back.","italic":true,"color":"dark_purple"},"\n\n",{"text":"Brought to you by the DSC Team!","color":"dark_purple","bold":true},"\n",{"text":"ozymandius ","bold":true},"- Main Dev\n",{"text":"21fishbowls","bold":true}," - Model & Texture Artist\n",{"text":"DanieloXXelo ","bold":true},"- Model & Texture Artist\n",{"text":"Lightigivhi ","bold":true},"- Model & Texture Arist\n",{"text":"Sweebow ","bold":true},"- Texture Artist\n",{"text":"ExistingEevee ","bold":true},"- Contributor\n",{"text":"JohnIsNotImpressed ","bold":true},"- Contributor\n",{"text":"Modrome ","bold":true},"- Contributor\n\n",{"text":"Looking for more news on Sacrilege? Want Sneak Peaks & Early Builds? Join the Occu","italic":true,"color":"light_purple"},{"text":"lt Analects ","italic":true,"color":"light_purple","bold":true},{"text":"Discord","bold":true,"color":"blue","clickEvent":{"action":"open_url","value":"https://discord.gg/PpZ4kfYx7V"}},{"text":"!","color":"light_purple"}]