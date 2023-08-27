function encodeString(input) {
    let encoded = "";
    let count = 1;

    for (let i = 0; i < input.length; i++) {
        if (input[i] === input[i + 1]) {
            count++;
        } else {
            if (count > 1) {
                encoded += count;
            }
            encoded += input[i];
            count = 1;
        }
    }

    return encoded;
}
function decodeString(input) {
    let decoded = "";
    let count = "";

    for (let i = 0; i < input.length; i++) {
        if (!isNaN(input[i])) {
            count += input[i];
        } else {
            if (count !== "") {
                decoded += input[i].repeat(parseInt(count, 10));
                count = "";
            } else {
                decoded += input[i];
            }
        }
    }

    return decoded;
}
const originalString = "AAAAAAAAAAABWWWWWWWWWWWBB";
const shortenedString = encodeString(originalString);
console.log("Shortened:", shortenedString);

const decodedString = decodeString(shortenedString);
console.log("Decoded:", decodedString);
