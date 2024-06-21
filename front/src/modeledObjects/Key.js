export class Key {
    constructor(value) {
        if (value === undefined) {
            this.value = '';
        } else {
            this.value = value;
        }
    }
}