package com.sky.sealedClass;

import javax.crypto.SealedObject;

public sealed class SealedKid extends SpecialAbstractClass {
    final class GrandKid extends SealedKid {}
}
