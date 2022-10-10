def next_pos(message):
    if message['action'] == 'left':
        if 0 <= session['curr_pos'][0] - 1 < session['width']:
            session['curr_pos'][0] -= 1
    elif message['action'] == 'right':
        if 0 <= session['curr_pos'][0] + 1 < session['width']:
            session['curr_pos'][0] += 1
    elif message['action'] == 'up':
        if 0 <= session['curr_pos'][1] - 1 < session['height']:
            session['curr_pos'][1] -= 1
    elif message['action'] == 'down':
        if 0 <= session['curr_pos'][1] + 1 < session['height']:
            session['curr_pos'][1] += 1
    elif message['action'] == 'arrow':
        pass

    pos = session['curr_pos']
    adj = []
    pit = 0
    wumpus = 0
    treasure = 0

    if session['dungeon'][pos[1]][pos[0]] == 1:
        pit = 2
        socketio.emit('lose', room=session['sid'])
    elif session['dungeon'][pos[1]][pos[0]] == 2:
        wumpus = 2
        socketio.emit('lose', room=session['sid'])
    elif session['dungeon'][pos[1]][pos[0]] == 3:
        treasure = 2
        socketio.emit('win', room=session['sid'])
    else:
        try:
            adj.append(session['dungeon'][pos[1]-1][pos[0]])
        except:
            pass

        try:
            adj.append(session['dungeon'][pos[1]+1][pos[0]])
        except:
            pass

        try:
            adj.append(session['dungeon'][pos[1]][pos[0]-1])
        except:
            pass

        try:
            adj.append(session['dungeon'][pos[1]][pos[0]+1])
        except:
            pass

        if 3 in adj:
            treasure = 1

        if 2 in adj:
            wumpus = 1
        
        if 1 in adj:
            pit = 1
        

    socketio.emit('update_status', 
                {"x": pos[0],
                "y": pos[1],
                "pit": pit,
                "wumpus": wumpus,
                "treasure": treasure}, 
                room=session['sid'])
Now, the client will know what is in the player’s adjacent position and we can add the icons to signalize this. Navigate back to main.js and let’s handle this new data. Change the handle of update_status in main.js to:

socket.on('update_status', (data)=>{
        curr = $(".curr_room")
        curr.removeClass("curr_room")

        room = $(".room[x='" + data['x'] + "'][y='" + data['y'] + "']")
        room.empty()
        if (data['pit'] == 2) {
            room.append("<i data-feather='x-circle'></i>")
        } else if (data['wumpus'] == 2) {
            room.append("<i data-feather='frown'></i>")
        } else if (data['treasure'] == 2) {
            room.append("<i data-feather='award'></i>")
        } else {
            if (data['pit'] == 1) {
                room.append("<i data-feather='wind'></i>")
            }
            if (data['wumpus'] == 1) {
                room.append("<i data-feather='alert-triangle'></i>")
            }
            if (data['treasure'] == 1) {
                room.append("<i data-feather='star'></i>")
            }
        }
        feather.replace()
        room.addClass("curr_room")
    })
