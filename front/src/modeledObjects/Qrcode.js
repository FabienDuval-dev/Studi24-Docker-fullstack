import { Key } from './Key';

import { QRCodeWriter } from '@zxing/library';
import { BarcodeFormat } from '@zxing/library';


export class Qrcode {
    constructor(key1, key2) {
        if (key1 === undefined || key2 === undefined) {
            alert('The keys are not defined');
        } else {
            this.key1 = new Key();
            this.key2 = new Key();
        }

        const qrCodeWriter = new QRCodeWriter();
        const combinedKeys = key1.value + key2.value;
        const qrCode = qrCodeWriter.encode(combinedKeys, BarcodeFormat.QR_CODE, 200, 200);
        this.value = qrCode;
    }
}
