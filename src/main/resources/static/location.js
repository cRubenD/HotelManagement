const form = document.querySelector("loginForm");

document.getElementById("submit-btn")
    .addEventListener("click", function (event) {
        event.preventDefault();
    });

function searchHotels() {

    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            let latitude = position.coords.latitude;
            let longitude = position.coords.longitude;

            const radius = document.getElementById("radius").value;

            const url = "http://localhost:5050/?radius=" + radius + "&latitude=" + latitude +
                "&longitude=" + longitude;

            fetch(url, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
            }})
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok ' + response.statusText);
                    }
                    return response.json(); // or response.text() for plain text
                })
                .then(data => {
                    displayHotels(data); // Handle the data from the response
                })
                .catch(error => {
                    console.error('There has been a problem with your fetch operation:', error);
                });
        })
    }
}

function displayHotels(hotels){
    const container = document.getElementById("container");
    container.innerHTML = "";

    if (hotels.length === 0) {
        const noHotelsMessage = document.createElement("p");
        noHotelsMessage.textContent = "No hotels found in the specified area.";
        container.appendChild(noHotelsMessage);
        return;
    }
    for (let hotel of hotels) {
        const hotelComponent = document.createElement("div");
        const hotelName = document.createElement("h2");
        hotelName.textContent = hotel.name;
        hotelComponent.appendChild(hotelName);

        const roomsHeader = document.createElement("h3");
        roomsHeader.textContent = "Rooms:";
        hotelComponent.appendChild(roomsHeader);

        const roomsList = document.createElement("ul");
        for (let room of hotel.rooms) {
            const roomItem = document.createElement("li");
            roomItem.textContent = "Room number " + room.roomNumber + " - Price: $" +
                room.price + "; Availability " + (room.isAvailable ? "Available" : "Not available");

            if (room.isAvailable) {
                const rentButton = document.createElement("button");
                rentButton.textContent = "Book";
                rentButton.addEventListener("click", function() {
                    bookRoom(hotel.name, room.roomNumber);
                });
                roomItem.appendChild(rentButton);
            }

            roomsList.appendChild(roomItem);
        }
        hotelComponent.appendChild(roomsList);

        container.appendChild(hotelComponent);
    }
}

function bookRoom(hotelName, roomNumber) {

    const checkInTime = document.getElementById("checkInTime").value;
    const checkOutTime = document.getElementById("checkOutTime").value;

    if (!checkInTime || !checkOutTime) {
        alert("Please select both check-in and check-out times.");
        return;
    }

    if (confirm("Do you want to book room number " + roomNumber + " at " + hotelName + "?")) {
        const reservation = {
            room: {
                roomNumber: roomNumber,
                hotel: {
                    name: hotelName
                }

            },
            checkInTime: checkInTime,
            checkOutTime: checkOutTime
        };

        fetch("http://localhost:5050/api/reservation/create", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(reservation)
        })
            .then(response => response.text())
            .then(text => {
                try {
                    const data = JSON.parse(text);
                    alert("Room booked successfully!");
                    console.log(data);
                } catch (error) {
                    console.error('Failed to parse JSON:', text);
                    alert('Error booking room. Please try again.');
                }
            })
            .catch(error => {
                console.error('There has been a problem with your fetch operation:', error);
            });
    }
}

